package com.mall.march.marchproject.service;

import com.mall.march.marchproject.dto.UserDto;
import com.mall.march.marchproject.entity.User;
import com.mall.march.marchproject.repository.UserRepository;
import org.apache.naming.factory.MailSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private static final String FROM_ADDRESS = "SENDER_EMAIL_ADDRESS";
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override // 회원가입
    public int userRegister(User user) {

        if (userRepository.existsByUserId(user.getUserId())) {
            return 1;
            // 아이디 중복
        } else if(!userRepository.existsByUserId(user.getUserId())) {
            userRepository.save(user);
            // 회원가입 성공
        }
        return 2;
    }

    @Override // 로그인
    public int userLogin(User user, HttpSession session) {

        if(!userRepository.existsByUserIdAndAndUserPassword(user.getUserId(), user.getUserPassword())) {
            return 1;
            // 아이디 패스워드 불일치
        } else if(userRepository.existsByUserIdAndAndUserPassword(user.getUserId(), user.getUserPassword())) {
            User entity = userRepository.findUserByUserId(user.getUserId());
            // 해당 아이디로 유저 엔티티를 찾아서
            UserDto loginUser = UserDto.fromEntity(entity);
            // Dto로 변환시켜서
            System.out.println(loginUser);

            session.setAttribute("loginUser", loginUser);
            // 세션에 Dto 저장.
            // 로그인 성공
        }
        return 2;
    }


}