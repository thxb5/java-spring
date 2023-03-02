package com.example.study.controller;

import com.example.study.entity.User;
import com.example.study.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@RequiredArgsConstructor
@Controller
public class MyController {
    @Autowired
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

    @PostMapping("/join")
        public String join(@RequestParam(value = "name") String name, @RequestParam(value = "id") String id, @RequestParam(value = "pw") String pw, @RequestParam(value = "email") String email){
            userRepository.save(User.builder().user_name(name).user_id(id).user_pw(pw).user_email(email).build());
        return "redirect:/";
    }

}
