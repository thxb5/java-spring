package com.study.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {
	
	@Autowired
	private EmpMapper empMapper;

	@GetMapping("/list")
	public String list(Model model) {
		 List<Emp> lst = empMapper.selectAll();
		 model.addAttribute("list", lst);
		 return "list";
	}
	
	@GetMapping("/delete")
	public String delete(int empno) {
		empMapper.delete(empno);
		return "redirect:/list";
	}
	
	@GetMapping("/update")
	public String update(int empno, Model model) {
		Emp emp = (Emp) empMapper.selectOne(empno);
		model.addAttribute("emp", emp);
		return "update";
	}
	
	@PostMapping("/update")
	public String update1(Emp emp) {
		empMapper.update(emp);
		return "redirect:/list";
	}
	
	@GetMapping("/insert")
	public String insert1() {
		return "/insert";
	}
	
	@PostMapping("/insert")
	public String insert(Emp emp) {
		empMapper.insert(emp);
		return "redirect:/list";
	}
	
}//class
