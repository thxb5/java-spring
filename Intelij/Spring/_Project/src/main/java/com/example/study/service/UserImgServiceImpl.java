package com.example.study.service;

import com.example.study.entity.UserImg;
import com.example.study.repository.UserImgRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class UserImgServiceImpl implements UserImgService {

    private final UserImgRepository userImgRepository;

    @Value("${spring.servlet.multipart.location}")
    private String userImgDir;

    //유저 이미지 생성 및 변경
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

            //해당 유저가 가진 프로필 이미지 파일 삭제
            String dirPath = "C:/_Intellij/Spring/_Project/src/main/resources/static/images/userImg";
            File dirFile = new File(dirPath);
            String fileList[] = dirFile.list();
            for(int i = 0; i < fileList.length; i++) {
                String chkFileNm = fileList[i];
                if(chkFileNm.startsWith(userId+"_")) {
                    File delFile = new File(dirPath + File.separator + chkFileNm);
                    delFile.delete();
                }
            }

            if (!img.isEmpty()) {
                UserImg imgg = UserImg.builder().origin_name(originalFileName).save_name(newFileName).build();

                //유저 이미지 유무 확인
                String imgCk = userImgRepository.userImgCheck(userId);



                //이미지 저장(저장 값이 존재하면 업데이트, 없으면 생성)
                if(imgCk != null) {
                    userImgRepository.userImgUpdate(imgg, userId);
                } else {
                    userImgRepository.userimg(imgg, userId);
                }

                //이미지 지정된 경로에 저장
                //File modifiedFileName = new File(newFileName);
                img.transferTo(new File(userImgDir));
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
