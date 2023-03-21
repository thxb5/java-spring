package com.study._vuejs0321.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping("/vue")
    public String vue() {
        return "vue/index";
    }
}
