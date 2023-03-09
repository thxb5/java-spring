package com.example.study.service;

import com.example.study.entity.User;
import com.example.study.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public int joinCheck2(String userid) {
        int result = userRepository.joinCheck(userid);
        return result;
    }

    @Override
    public User loginCheck2(String userId, String userPw) {
        User user = userRepository.loginCheck(userId,userPw);
        return user;
    }

    @Override
    public void userModify(User user) {
        userRepository.userUpdate(user);
    }

    @Override
    public User userInfo(User user) {
        User user2 = userRepository.userInfo(user);
        return user2;
    }

}//class
