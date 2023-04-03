package com.example.study.service;

import com.example.study.entity.Board;

import java.util.List;

public interface BoardService {
    int insertBd(Board board, String userId);
    List<Board> digitall(int bdList);
    Long boardId();
}
