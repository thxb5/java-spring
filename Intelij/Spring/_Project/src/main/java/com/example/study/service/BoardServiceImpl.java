package com.example.study.service;

import com.example.study.entity.Board;
import com.example.study.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public int insertBd(Board board, String userId) {

        Board board = boardRepository.boardInsert(board,userId);
        int result = boardRepository.boardId();
        return result;
    }

    @Override
    public List<String> digitAll() {

        List<String> list = boardRepository.digitAll();

        return list;
    }
}
