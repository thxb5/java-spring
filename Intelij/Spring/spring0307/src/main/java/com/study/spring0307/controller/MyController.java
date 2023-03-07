package com.study.spring0307.controller;

import com.study.spring0307.entity.Person;
import com.study.spring0307.repository.MyEntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MyController {
    private final MyEntityManager em;

    @GetMapping("/create")
    @ResponseBody
    public String create() {
        String str = em.create();
        return str;
    }

    @GetMapping("/update")
    @ResponseBody
    public String update() {
        String aa = em.update();
        return aa;
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Person> list() {
        List<Person> list = em.selectAll();
        return list;
    }

    @GetMapping("/delete")
    @ResponseBody
    public String delete() {
        String str = em.delete();
        return str;
    }
}
