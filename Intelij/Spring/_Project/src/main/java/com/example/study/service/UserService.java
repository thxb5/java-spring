package com.example.study.service;


import com.example.study.entity.User;

public interface UserService {
    int joinCheck2(String userid);
    User loginCheck2(String userId, String userPw);
}
