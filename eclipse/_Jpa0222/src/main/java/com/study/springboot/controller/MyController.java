package com.study.springboot.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.study.springboot.entity.Emp;
import com.study.springboot.jdbc.EmpDeptMapper;
import com.study.springboot.repository.EmpRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequiredArgsConstructor
@Log4j2
public class MyController {

	private final EmpRepository empRepository;
	private final EmpDeptMapper empDeptMapper;
	
	@GetMapping("/")
	public String root() {
		return "view/index";
	}
	
	@GetMapping("/list")
	public String ListEmp(Model model) {
		//List<Emp> list = empRepository.findAll();
		List<Emp> list = empDeptMapper.findAllEmp("%", "A");
		model.addAttribute("list", list);
		return "view/list";
	}
	
	@GetMapping("/search")
	public String search(Model model, String search, String type) {
		log.info("---search:"+search+", type:"+type);
		List<Emp> list = empDeptMapper.findAllEmp(search, type);
		model.addAttribute("list", list);
		return "view/list";
	}
	
	@GetMapping("/page/{num}")
	public String page(@PathVariable int num, Model model) {
		Pageable pageable = PageRequest.of(num-1, 5); //2번 페이지부터 5개씩 끊겠다,,
		Page<Emp> res = empRepository.findAll(pageable);
		log.info("total count: "+res.getTotalElements());
		log.info("total page: "+res.getTotalPages());
		log.info("total number: "+res.getNumber());
		log.info("total size: "+res.getSize());
//		res.stream().forEach(t->{
//			log.info(t);
//		});
		model.addAttribute("list",res);
		return "view/page";
	}
	
	@GetMapping("/page2")
	public String page2(@PageableDefault(page=0, size=5) //0페이지부터 시작,, 5개씩 뿌림
						Pageable pageable, Model model) {
		Page<Emp> res = empRepository.findAll(pageable);
		model.addAttribute("list",res);
		return "view/page2";
	}
	
	@GetMapping("/test")
	public String test() {
		return "view/test";
	}
	
}
