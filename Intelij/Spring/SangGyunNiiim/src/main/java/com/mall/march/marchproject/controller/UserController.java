package com.mall.march.marchproject.controller;

import com.mall.march.marchproject.entity.User;
import com.mall.march.marchproject.service.UserServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@Log4j2
public class UserController {

    private final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/toCustomer")
    public String toBuyer() {
        return "/mypage/customer/mypage-customer-main";
    }

    @ResponseBody
    @PostMapping("/register")
    public int userRegister(@RequestBody User user) {
        return userServiceImpl.userRegister(user);
    }

    @ResponseBody
    @PostMapping("/login")
    public int userLogin(@RequestBody User user, HttpSession session) {
        return userServiceImpl.userLogin(user, session);
    }

    @GetMapping("/toLogout")
    public String userLogout(User user, HttpSession session) {
        session.removeAttribute("loginUser");
        return "layout/view";
    }

    @GetMapping("/carousel")
    public String te(Model model) {
        model.addAttribute("param1","data1");
        model.addAttribute("param2","data2");
        return "fragments/carousel";
    }
    //    주문시 주문 내역 메일로 발송하는 기능 생각해보기
}
