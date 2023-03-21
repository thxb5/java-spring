package com.example.study.repository;

import com.example.study.entity.Board;
import com.example.study.entity.BoardImg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BoardImgRepository extends JpaRepository<BoardImg, Long> {

    //게시글 작성
    @Transactional
    @Query(value = "insert into board_img(bd_origin_name, bd_save_name, bd_userimg_path, board_board_id) values (:#{#boardImg.bd_origin_name}, :#{#boardImg.bd_save_name}, :#{#boardImg.bd_userimg_path}, :boardId)", nativeQuery = true)
    void board(BoardImg boardImg, int boardId);
}
