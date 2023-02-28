package com.study.myBatisEx;

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
	
	@GetMapping("/root")
	public String root() {
		return "root";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		List<Emp> elst = empMapper.selectEmpTempAll();
		model.addAttribute("list", elst);
		
		for (Emp emp :elst) {
			System.out.println(emp.getEmpno() + ", " + emp.getEname());
		}
		
		return "list";
	}
	
	@PostMapping("/insert")
	public String insert(Emp emp, Model model) {
		int res = empMapper.insertEmpTemp(emp);
		System.out.println(res + "");
		
		return "redirect:/list";
	}
	
	@GetMapping("/delete")
	public String delete(int empno, Model model) {
		int res = empMapper.deleteEmpTemp(empno);
		model.addAttribute("res", res);		
		
		return "redirect:/list";
	}
	
//	실제로 업데이트가 동작하는 부분
	@PostMapping("/update")
	public String update(Emp emp) {
		empMapper.updateEmpTemp(emp);
		return "redirect:/list";
	}
	
//	업데이트 뷰 부분
	@GetMapping("/updateForm")
	public String updateForm(Model model, int empno ) {
		List<Emp> elst = empMapper.selectEmpTemp(empno);
		model.addAttribute("elst", elst);
		return "updateForm";
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
			
//			file 경로 임의 지정
			String uploadPath = "c:\\upload/test/abc/";
			
			File fileUpload = new File(uploadPath, file.getOriginalFilename());
			
//			생성 될 경로가 없을 경우, 파일을 생성한다.
			if (!fileUpload.exists()) {
				System.out.println(uploadPath + " : 파일 경로 생성완료");
				fileUpload.mkdirs();
			}
			file.transferTo(fileUpload);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
