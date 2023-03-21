package com.example.study.repository;

import com.example.study.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

    //게시글 작성
    @Transactional
    @Query(value = "insert into board(bd_list, bd_price, bd_title, bd_content, user_user_id) values (:#{#board.bd_list}, :#{#board.bd_price}, :#{#board.bd_title}, :#{#board.bd_content}, :userId)", nativeQuery = true)
    void board(Board board, String userId);

    //게시글 아이디 찿기
    @Transactional
    @Query(value = "select bd_no from board where user_user_id = :userId", nativeQuery = true)
    void boardId();
}
