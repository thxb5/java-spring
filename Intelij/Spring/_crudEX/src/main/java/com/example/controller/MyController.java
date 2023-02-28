package com.example.controller;


import com.example.entity.Movie;
import com.example.repository.MovieCategoryRepository;
import com.example.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequiredArgsConstructor
@Log4j2
public class MyController {
	@Autowired
	private final MovieCategoryRepository movieCategoryRepository;
	@Autowired
	private final MovieRepository movieRepository;
	@GetMapping("/")
	public String root() {
		//List<MovieList> list = movieListRepository.findAll();
		//model.addAttribute(list);
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

//	@PostMapping("/insert")
//	public String insert(Movie movie, int type) {
//		int idx
//		return "view/manage";
//	}

	@PostMapping("/insert")
	public String insert(@RequestParam(value="title") String title, @RequestParam(value="content") String content, @RequestParam(value="kategorie") Long kategorie) {
		Movie newMovie = new Movie();

		//movieListRepository.save(Movie.builder().title(title).content(content).kategorie(kategorie).build());
		return "view/manage";
	}

	@GetMapping("/rename")
	public String renameForm(Model model) {
//		movieListRepository.findAll(MovieList.builder().)
		return "view/rename";
	}

}
