package com.study.springboot.controller;

import com.study.springboot.entity.MovieList;
import com.study.springboot.repository.MovieListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Log4j2
public class MyController {

	@Autowired
	private final MovieListRepository movieListRepository;
	@GetMapping("/")
	public String root(Model model) {
		List<MovieList> list = movieListRepository.findAll();
		model.addAttribute(list);
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

	@GetMapping("/insert")
	public String insertForm() {
		return "view/insert";
	}

	@PostMapping("/insert")
	public String insert(@RequestParam(value="title") String title, @RequestParam(value="content") String content, @RequestParam(value="kategorie") int kategorie) {
		movieListRepository.save(MovieList.builder().title(title).content(content).kategorie(kategorie).build());
		return "view/manage";
	}

	@GetMapping("/rename")
	public String renameForm(Model model) {
//		movieListRepository.findAll(MovieList.builder().)
		return "view/rename";
	}

}
