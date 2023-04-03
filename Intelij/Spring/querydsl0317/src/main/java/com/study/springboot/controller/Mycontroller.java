package com.study.springboot.controller;

import com.study.springboot.dao.EmpMapper;
import com.study.springboot.entity.Tables;
import com.study.springboot.repositroy.TablesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.PostConstruct;

@SessionAttributes("user")
@Controller
@RequiredArgsConstructor
public class Mycontroller {

    private final TablesRepository tablesRepository;
    @Autowired
    EmpMapper empMapper;

    @ModelAttribute("user")
    public String setUpUserForm() {
        return new String();
    }
    @GetMapping("/hello")
    public String hello(Model model, @ModelAttribute("user") String user) {
        model.addAttribute("user", "test1111");
        System.out.println(empMapper.findAll());
        model.addAttribute("list", empMapper.findAll());
        return "redirect:/table";
    }

    @GetMapping("/table")
    public String table(Model model, @ModelAttribute("user") String user) {
        if (user.equals("test")) {
            System.out.println("로그인!!");
        } else {
            System.out.println("로그아웃!!");
        }
        model.addAttribute("list", tablesRepository.findAll() );
        return "table";
    }

    //@PostConstruct
    public void insert() {
        Tables tables = Tables.builder().number("abc").name("abc").build();
        tablesRepository.save(tables);
    }
}
