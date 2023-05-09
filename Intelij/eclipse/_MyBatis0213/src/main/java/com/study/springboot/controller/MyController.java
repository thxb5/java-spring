package com.study.springboot.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.study.springboot.jdbc.Board;
import com.study.springboot.jdbc.BoardMapper;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequiredArgsConstructor
@Log4j2
public class MyController {
	
	//required랑 final 처리를 해주면 autowired와 같은 효과가 나타난다
	final BoardMapper boardMapper;
	
	@GetMapping("/test1")
	public void ex1(Model mm, String writer, HttpSession ses) {
		List<Board> list = boardMapper.findAll(writer);
		mm.addAttribute("ddd", list);
		ses.setAttribute("user", "admin");
	}
	
	@GetMapping("/test2")
	public String ex2(Model ss, HttpSession ses) {
		List<Board> list = boardMapper.findAll(null);
		ss.addAttribute("ddd", list);
		String user = (String) ses.getAttribute("user");
		log.info("---------------------사용자:"+user);
		return "test1";
	}
	
}//class
