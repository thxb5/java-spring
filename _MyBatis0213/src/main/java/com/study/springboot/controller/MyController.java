package com.study.springboot.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.study.springboot.jdbc.Board;
import com.study.springboot.jdbc.BoardMapper;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MyController {
	
	//required랑 final 처리를 해주면 autowired와 같은 효과가 나타난다
	final BoardMapper boardMapper;
	
	@GetMapping("/test1")
	public void ex1(Model mm) {
		List<Board> list = boardMapper.findAll();
		mm.addAttribute("ddd", list);
	}
	
	@GetMapping("/test2")
	public String ex2(Model ss) {
		ss.addAttribute("ddd", "테스트");
		return "test1";
	}
	
}//class
