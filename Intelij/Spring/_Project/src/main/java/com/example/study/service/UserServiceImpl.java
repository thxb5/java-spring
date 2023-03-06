package com.example.study.service;

import com.example.study.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public int joinCheck2(String userid) {
        System.out.println("imple user_id = " + userid);
        int result = userRepository.joinCheck(userid);
        return result;
    }
}
