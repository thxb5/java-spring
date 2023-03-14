package com.mall.march.marchproject.service;
import com.mall.march.marchproject.dto.UserDto;
import com.mall.march.marchproject.entity.User;

import javax.servlet.http.HttpSession;

public interface UserService {

    int userRegister(User user);
    int userLogin(User user, HttpSession session);

}
