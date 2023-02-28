package com.study.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmpController {
	
	@Autowired
	EmpMapper empMapper;
	
	@GetMapping("/list")
	public String list(Model model) {
		List<Emp> lst = empMapper.findAll();
		for (Emp emp : lst) {
			System.out.println(emp);
		}
		model.addAttribute("list", lst);
		return "list";
	}
}
