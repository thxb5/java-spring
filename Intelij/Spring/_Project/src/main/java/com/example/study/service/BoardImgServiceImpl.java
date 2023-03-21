package com.example.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class BoardImgServiceImpl implements BoardImgService {


    @Override
    public int insertBdImg(MultipartFile[] imgs, int boardId) {
        return 0;
    }
}
