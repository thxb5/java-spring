package com.example.study.repository;

import com.example.study.entity.Board;
import com.example.study.entity.BoardImg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BoardImgRepository extends JpaRepository<BoardImg, Long> {

    //게시글 작성
    @Transactional
    @Query(value = "insert into board_img(bd_origin_name, bd_save_name, bd_img_path, bd_no) values (:#{#boardImg.bd_origin_name}, :#{#boardImg.bd_save_name}, :#{#boardImg.bd_img_path}, :boardId)", nativeQuery = true)
    void boardImgInsert(BoardImg boardImg, Long boardId);

    //카테고리 이미지 가져오기
    @Transactional
    @Query(value = "select bd_img_path from board_img where bd_no = :bdNo", nativeQuery = true)
    List<BoardImg> kategorieImg(Long bdNo);

}
