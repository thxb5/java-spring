package com.example.study.service;

import org.springframework.web.multipart.MultipartFile;

public interface BoardImgService {
    int insertBdImg(MultipartFile[] imgs, int boardId);
}
