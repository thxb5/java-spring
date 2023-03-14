package com.example.study.repository;

import com.example.study.entity.UserImg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserImgRepository extends JpaRepository<UserImg, Long> {

    @Transactional
    @Query(value = "insert into user_img(origin_name, save_name, user_user_id) values (:#{#userImg.origin_name}, :#{#userImg.save_name}, :userId)", nativeQuery = true)
    void userimg(UserImg userImg, String userId);
}
