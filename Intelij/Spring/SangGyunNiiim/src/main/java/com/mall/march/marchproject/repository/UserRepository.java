package com.mall.march.marchproject.repository;

import com.mall.march.marchproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    boolean existsByUserIdAndAndUserPassword(String userId, String userPassword);
    boolean existsByUserId(String userId);
    User findUserByUserId(String userId);
}
