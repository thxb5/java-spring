package com.mall.march.marchproject.controller;

import com.mall.march.marchproject.dto.ImgDto;
import com.mall.march.marchproject.dto.ItemDto;
import com.mall.march.marchproject.service.ImgService;
import com.mall.march.marchproject.service.ItemService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Log4j2
@Controller
public class MyController {

	private final ItemService itemService;
	private final ImgService imgService;

	public MyController(ItemService itemService, ImgService imgService) {
		this.itemService = itemService;
		this.imgService = imgService;
	}


	@GetMapping("/")
	public String root(Model model) {
	List<ItemDto> itemList = itemService.selectAllItems();
	List<ImgDto> imgList = imgService.selectImgsDistinct();
	// 등록되어있는 모든 상품 추출
	model.addAttribute("imgList", imgList);
	model.addAttribute("itemList", itemList);
		return "/layout/view";
	}
	@GetMapping("/toRegister")
	public String toRegister() {
		return "/member/register";
	}
	@GetMapping("/toLogin")
	public String toLogin() {
		return "/member/login";
	}
	@GetMapping("/toHeader")
	public String toHeader() {
		return "/fragments/header";
	}
	@GetMapping("/toFooter")
	public String toFooter() {
		return "/fragments/footer";
	}
	@GetMapping("/toCarousel")
	public String toCarousel() {
		return "/fragments/carousel";
	}
	@GetMapping("/toRegitem")
	public String toRegitem() {
		return "/mypage/admin/regitem";
	}


}
