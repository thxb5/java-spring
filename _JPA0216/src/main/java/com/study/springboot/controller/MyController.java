package com.study.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.study.springboot.entity.MyData;
import com.study.springboot.repository.MyDataRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequiredArgsConstructor
public class MyController {
	
	@Autowired
	private final MyDataRepository myDataRepository;
	
	@GetMapping("/")
	public String list(Model model) {
		List<MyData> list = myDataRepository.findAll();
		model.addAttribute("list", list);
		return "view/list";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(Model model, @PathVariable long id) {
		Optional<MyData> myData = myDataRepository.findById(id);
		//Optional은 null을 대비한다
		log.info("---->"+myData);
		if(myData.isPresent()) {
			model.addAttribute("myData", myData.get().getMemo());
		} else {
			model.addAttribute("myData", "없음");
		}
		
		return "view/edit";
	}
	
	//@PostConstruct
	public void init() {
		log.info("-----------여기요------------");
		MyData d1 = MyData.builder()
				.name("김")
				.age(34)
				.mail("kim@test.co.kr")
				.memo("이것은 kim의 자료").build();
		log.info(d1);
		myDataRepository.saveAndFlush(d1);
	}
	
} //class
