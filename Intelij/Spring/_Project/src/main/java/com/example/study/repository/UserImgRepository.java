package com.example.study.repository;

import com.example.study.entity.UserImg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserImgRepository extends JpaRepository<UserImg, Long> {

    //유저 이미지 삽입
    @Transactional
    @Query(value = "insert into user_img(origin_name, save_name, user_user_id) values (:#{#userImg.origin_name}, :#{#userImg.save_name}, :userId)", nativeQuery = true)
    void userimg(UserImg userImg, String userId);

    //유저 이미지 수정
    @Transactional
    @Query(value = "update user_img set origin_name = :#{#userImg.origin_name}, save_name = :#{#userImg.save_name} where user_user_id = :userId", nativeQuery = true)
    void userImgUpdate(UserImg userImg, String userId);

    //유저 이미지 유무 확인
    @Transactional
    @Query(value = "select save_name from user_img where user_user_id = :userId", nativeQuery = true)
    String userImgCheck(String userId);

    @Transactional
    @Query(value = "delete from user_img where user_user_id = :userId", nativeQuery = true)
    void userImgDelete(String userId);

}
