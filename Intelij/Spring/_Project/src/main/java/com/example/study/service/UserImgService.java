package com.example.study.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface UserImgService {
    int userImg(MultipartFile[] imgs, String userId) throws IOException;
    void userImgDelete(String userId);
    String userImgSearch(String userId);
}
