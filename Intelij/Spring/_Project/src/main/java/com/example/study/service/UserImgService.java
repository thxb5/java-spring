package com.example.study.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UserImgService {
    int userImg(MultipartFile[] imgs, String userId) throws IOException;
}
