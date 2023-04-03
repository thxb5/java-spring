package com.example.study.repository;

import com.example.study.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Transactional
    @Query(value = "select count(*) from user where user_id = :userid", nativeQuery = true)
    int joinCheck(@Param("userid") String userid);

    @Transactional
    @Query(value = "select * from user where user_id = :userId and user_pw = :userPw", nativeQuery = true)
    User loginCheck(@Param("userId") String userId, @Param("userPw") String userPw);

    @Transactional
    @Query(value = "select * from user where user_id = :#{#user.user_id}", nativeQuery = true)
    User userInfo(User user);

    @Transactional
    @Query(value = "update user set user_pw = :#{#user.user_pw}, user_nickname = :#{#user.user_nickname}, user_email = :#{#user.user_email} where user_id = :#{#user.user_id}", nativeQuery = true)
    void userUpdate(User user);


}
