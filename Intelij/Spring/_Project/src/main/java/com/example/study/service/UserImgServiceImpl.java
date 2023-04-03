package com.example.study.service;

import com.example.study.entity.UserImg;
import com.example.study.repository.UserImgRepository;
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
public class UserImgServiceImpl implements UserImgService {

    private final UserImgRepository userImgRepository;

    @Value("${file.dir.userImg}")
    private String userImgDir;

    //유저 이미지 생성 및 변경
    @Override
    @ResponseBody
    public int userImg(MultipartFile[] imgs, String userId) throws IOException {

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
            String newFileName = userId + "_" + nowDate + extension;

            //해당 유저가 가진 프로필 이미지 파일 삭제.
            File dirFile = new File(userImgDir);
            String fileList[] = dirFile.list();
            for(int i = 0; i < fileList.length; i++) {
                String chkFileNm = fileList[i];
                if(chkFileNm.startsWith(userId+"_")) {
                    File delFile = new File(userImgDir + File.separator + chkFileNm);
                    delFile.delete();
                }
            }

            if (!img.isEmpty()) {
                String savePath = userImgDir + newFileName;
                UserImg imgg = UserImg.builder().u_origin_name(originalFileName).u_save_name(newFileName).u_img_path(savePath).build();

                //유저 이미지 유무 확인
                String imgCk = userImgRepository.userImgCheck(userId);



                //이미지 저장(저장 값이 존재하면 업데이트, 없으면 생성)
                if(imgCk != null) {
                    userImgRepository.userImgUpdate(imgg, userId);
                } else {
                    userImgRepository.userimg(imgg, userId);
                }

                //이미지 지정된 경로에 저장
                File modifiedFileName = new File(userImgDir + newFileName);
                img.transferTo(modifiedFileName);
            }
        }
        return 1;
    }

    //유저 이미지 삭제
    @Override
    public void userImgDelete(String userId) {
        userImgRepository.userImgDelete(userId);
    }

    @Override
    public String userImgSearch(String userId) {
        String imgCk = userImgRepository.userImgCheck(userId);
        return imgCk;
    }


}
