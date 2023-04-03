package com.example.study.service;

import com.example.study.entity.BoardImg;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface BoardImgService {
    String insertBdImg(MultipartFile[] imgs, Long boardId) throws IOException;
    List<BoardImg> boardImgList(Long bdNo);

}
