package com.example.study.repository;

import com.example.study.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

    //게시글 작성
    @Transactional
    @Query(value = "insert into board(bd_list, bd_price, bd_title, bd_content, user_user_id) values (:#{#board.bdList}, :#{#board.bdPrice}, :#{#board.bdTitle}, :#{#board.bdContent}, :userId)", nativeQuery = true)
    void boardInsert(Board board, String userId);

    //게시글 아이디 찿기
    @Transactional
    @Query(value = "select LAST_INSERT_ID()", nativeQuery = true)
    int boardId();

    //디지털기기 게시글 찾기
    @Transactional
    @Query(value = "select * from board where bd_list = 1", nativeQuery = true)
    List<String> digitAll();
}
