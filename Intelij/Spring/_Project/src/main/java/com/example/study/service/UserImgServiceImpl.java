package com.example.study.service;

import com.example.study.entity.UserImg;
import com.example.study.repository.UserImgRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class UserImgServiceImpl implements UserImgService {

    private final UserImgRepository userImgRepository;

    @Override
    public int userImg(MultipartFile[] imgs, String userId) throws IOException {

        for (MultipartFile img : imgs) {
            // 기존 파일 이름
            String originalFileName = img.getOriginalFilename();

            int result = originalFileName.lastIndexOf(".");
            int length = originalFileName.length();

            //기존 파일 확장자
            String extension = originalFileName.substring(result, length);

            //저장할 새로운 파일 이름
            String newFileName = userId + "_" + System.nanoTime() + extension;

            if (!img.isEmpty()) {
                UserImg imgg = UserImg.builder().origin_name(originalFileName).save_name(newFileName).build();
                //이미지 저장
                userImgRepository.userimg(imgg, userId);
                System.out.println("originalFileName = " + originalFileName);
                System.out.println("newFileName = " + newFileName);

                //이미지 지정된 경로에 저장
                File modifiedFileName = new File(newFileName);
                img.transferTo(modifiedFileName);
            }


        }

        return 1;
    }

}
