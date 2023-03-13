package com.example._jsp0313.controller;

import com.example._jsp0313.dto.GradeDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class MyController {
    @GetMapping("/")
    public String hello(String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    @PostMapping("/review")
    public ResponseEntity<Long> review(@RequestBody GradeDto gradeDto) {
        System.out.println("gradeDto = " + gradeDto);
        return new ResponseEntity<>(gradeDto.getId(), HttpStatus.OK);
    }
}
