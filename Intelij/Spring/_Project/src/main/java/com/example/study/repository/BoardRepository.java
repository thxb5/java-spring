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
    Board boardInsert(Board board, String userId);

    //게시글 아이디 찿기
    @Transactional
    @Query(value = "select LAST_INSERT_ID()", nativeQuery = true)
    int boardId();

    //디지털기기 게시글 찾기
    @Transactional
    @Query(value = "SELECT a1.bd_title,a1.bd_price, a2.bd_userimg_path FROM board a1, board_img a2 WHERE a1.bd_list = 1 and a2.board_bd_no = a1.bd_no", nativeQuery = true)
    List<String> digitAll();
}
