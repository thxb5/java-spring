package com.example.study.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface BoardImgService {
    int insertBdImg(MultipartFile[] imgs, int boardId) throws IOException;
}
