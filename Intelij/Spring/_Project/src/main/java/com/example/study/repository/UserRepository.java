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


}
