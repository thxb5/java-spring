package com.example.study.service;

import com.example.study.entity.BoardImg;
import com.example.study.repository.BoardImgRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class BoardImgServiceImpl implements BoardImgService {

    private final BoardImgRepository boardImgRepository;

    @Value("${file.dir.bdImg}")
    private String bdImgDir;


    @Override
    @ResponseBody
    public int insertBdImg(MultipartFile[] imgs, int boardId) throws IOException {

        for (MultipartFile img : imgs) {
            // 기존 파일 이름
            String originalFileName = img.getOriginalFilename();

            int result = originalFileName.lastIndexOf(".");
            int length = originalFileName.length();

            //기존 파일 확장자
            String extension = originalFileName.substring(result, length);

            //파일명에 붙는 현재 시간
            Date currentDate = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd");
            String nowDate = simpleDateFormat.format(currentDate);

            //저장할 새로운 파일 이름
            String newFileName = boardId + "_" + nowDate + extension;

            if (!img.isEmpty()) {
                String savePath = bdImgDir + newFileName;
                BoardImg imgg = BoardImg.builder().bd_origin_name(originalFileName).bd_save_name(newFileName).bd_userimg_path(savePath).build();

                boardImgRepository.boardImgInsert(imgg, boardId);

                //이미지 지정된 경로에 저장
                File modifiedFileName = new File(bdImgDir + newFileName);
                img.transferTo(modifiedFileName);
            }
        }
        return 1;
    }

}
