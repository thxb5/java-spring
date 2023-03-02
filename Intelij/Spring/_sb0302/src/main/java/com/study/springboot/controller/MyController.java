package com.study.springboot.controller;

import java.util.List;

import com.study.springboot.entity.Notice;
import com.study.springboot.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.study.springboot.entity.Detail;
import com.study.springboot.entity.Emp;
import com.study.springboot.entity.Genre;
import com.study.springboot.repository.DetailRepository;
import com.study.springboot.repository.EmpRepository;
import com.study.springboot.repository.GenreRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.annotation.PostConstruct;

@Controller
@RequiredArgsConstructor
@Log4j2
public class MyController {

	private final NoticeRepository noticeRepository;
	private final EmpRepository empRepository;
	private final GenreRepository genreRepository;
	private final DetailRepository detaileRepository;

	@GetMapping("/")
	public String root() {
		return "view/index";
	}

	@GetMapping("/list")
	public String listEmp(Model model) {
		List<Emp> list = empRepository.findAll();
		//List<Emp> list = empDeptMapper.findAllEmp("%", "A");
		model.addAttribute("list", list);
		return "view/list";
	}

	@GetMapping("/search")
	public String search(Model model, String search, String type) {
		log.info("---search:" + search + ", type:" + type);
		//List<Emp> list = empDeptMapper.findAllEmp(search, type);
		//model.addAttribute("list", list);
		return "view/list";
	}

	@GetMapping("/page2")
	public String listAction(Model model, @PageableDefault(page = 0, size = 10) Pageable pageable) {
		List<Notice> list = noticeRepository.findAll();
		final int start = (int) pageable.getOffset();
		final int end = Math.min((start + pageable.getPageSize()), list.size());
		final Page<Notice> page = new PageImpl<>(list.subList(start, end), pageable, list.size());

		model.addAttribute("list", page);
		return "view/list";
	}
}

