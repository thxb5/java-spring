package com.study.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
	
	@GetMapping("/list")
	public String list() {
		return "/list.html";
	}
	
	@GetMapping("/test")
	public String test(Model model) {
		model.addAttribute("ttt", "1234");
		model.addAttribute("yyy", "5678");
		return "/test";
	}
	
	@GetMapping("/aaa")
	public String aaa(String ee, String ff, Model model) {
		model.addAttribute("ss", ee);
		model.addAttribute("ff", ff);
		return "/result";
	}
	
	
}
