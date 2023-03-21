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
    @Query(value = "insert into user_img(u_origin_name, u_save_name, u_userimg_path, user_user_id) values (:#{#userImg.u_origin_name}, :#{#userImg.u_save_name}, :#{#userImg.u_userimg_path}, :userId)", nativeQuery = true)
    void userimg(UserImg userImg, String userId);

    //유저 이미지 수정
    @Transactional
    @Query(value = "update user_img set u_origin_name = :#{#userImg.u_origin_name}, u_save_name = :#{#userImg.u_save_name}, u_userimg_path = :#{#userImg.u_userimg_path} where user_user_id = :userId", nativeQuery = true)
    void userImgUpdate(UserImg userImg, String userId);

    //유저 이미지 유무 확인
    @Transactional
    @Query(value = "select u_userimg_path from user_img where user_user_id = :userId", nativeQuery = true)
    String userImgCheck(String userId);

    @Transactional
    @Query(value = "delete from user_img where user_user_id = :userId", nativeQuery = true)
    void userImgDelete(String userId);

}
