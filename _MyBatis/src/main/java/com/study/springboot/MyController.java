package com.study.springboot;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class MyController {
	@Autowired
	private EmpMapper empMapper;
	
	@GetMapping("/now")
	public String root() {
		return "root";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		List<Emp> elst = empMapper.findAll();
		model.addAttribute("list", elst);
		return "list";
	}
	
	@PostMapping("/insert")
	public String insert(Emp emp, Model model) {
		int res = empMapper.save(emp);
		model.addAttribute("res", res);
		return "redirect:/list";
	}
	
	@GetMapping("/delete")
	public String delete(int empno) {
		empMapper.delete(empno);
		return "redirect:/list";
	}
	
	@GetMapping("/update")
	public String update(int empno, Model model) {
		Emp emp = empMapper.selectOne(empno);
		model.addAttribute("emp", emp);
		return "update";
	}
	
	@PostMapping("/update")
	public String update(Emp emp) {
		empMapper.update(emp);
		return "redirect:/list";
	}
	
	@PostMapping("/upload3")
	@ResponseBody
	public void FileUpload3(MultipartHttpServletRequest request) {
		try {
			System.out.println("/upload3");
			String test = request.getParameter("test");
			System.out.println(test);
			MultipartFile file = request.getFile("file");
			System.out.println(file.getOriginalFilename());
			
			// file 경로 임의 지정
			String uploadPath = "C:\\upload/test/abc/";
			
			File fileUpload = new File(uploadPath, file.getOriginalFilename());
			
			// 생성 될 경로가 없을 경우, 파일을 생성한다.
			if (!fileUpload.exists()) {
				System.out.println(uploadPath + " : 파일 경로 생성완료");
				fileUpload.mkdirs();
			}
			file.transferTo(fileUpload);
		} catch (Exception e) {
		}
		
	} //FileUpload3()
	
} //class
