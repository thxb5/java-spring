package com.example.study.service;

import com.example.study.entity.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {


    @Override
    public int insertBd(Board board, String userId) {
        return 0;
    }
}
