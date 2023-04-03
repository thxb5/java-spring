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

        boardRepository.boardInsert(board,userId);
        return 1;
    }

    @Override
    public List<Board> digitall(int bdList) {

        List<Board> list = boardRepository.digitAll(bdList);
        System.out.println("list = " + list);
        return list;
    }

    @Override
    public Long boardId() {
        Long result = boardRepository.boardId();
        return result;
    }

}
