package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.MovieList;
import com.example.demo.jdbc.MovieMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequiredArgsConstructor
@Log4j2
public class MyController {
	
	@Autowired
	private MovieMapper movieMapper;
	
	@GetMapping("/")
	public String root() {
		return "view/index";
	}
	
	@GetMapping("/list")
	public String list() {
		return "view/list";
	}
	
	@GetMapping("/manage")
	public String manage() {
		return "view/manage";
	}
	
	@PostMapping("/insert")
	public String insert(MovieList movieList) {
		System.out.println(">>>>>>>>>>>"+movieList);
		movieMapper.insert(movieList);
		return "manage";
	}
}
