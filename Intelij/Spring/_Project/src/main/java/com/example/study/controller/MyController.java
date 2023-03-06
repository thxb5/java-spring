package com.example.study.controller;

import com.example.study.entity.User;
import com.example.study.repository.UserRepository;
import com.example.study.service.UserServiceImpl;
import groovy.util.logging.Log4j2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class MyController {

    private final UserServiceImpl userServiceImpl;
    private final UserRepository userRepository;

    @GetMapping("/")
    public String header(){
        return "view/main";
    }

    @PostMapping("/login")
    public  String login() {
        return "redirect:/";
    }

    @GetMapping("/join")
    public String joinPage() {
        return "view/join";
    }

    //회원가입
    @PostMapping("/joinUser")
        public String join(@RequestParam(value = "userNickname") String userNickname, @RequestParam(value = "userId") String userId, @RequestParam(value = "userPw") String userPw, @RequestParam(value = "userEmail") String userEmail){
            userRepository.save(User.builder().userId(userId).userPw(userPw).userNickname(userNickname).userEmail(userEmail).build());
        return "redirect:/";
    }

    //가입시 아이디 중복체크
    @PostMapping("joincheck.do")
    public @ResponseBody int joincheck3(@RequestParam("userid")String userid) {
        int result = userServiceImpl.joinCheck2(userid);
        return result;
    }
}
