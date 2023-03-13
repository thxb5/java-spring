package com.example.study.service;

import com.example.study.entity.UserImg;
import com.example.study.repository.UserImgRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserImgServiceImpl implements UserImgService {

    private final UserImgRepository userImgRepository;

    @Override
    public int userImg(UserImg userImg) {
        userImgRepository.userimg(userImg);
        return 1;
    }
}
