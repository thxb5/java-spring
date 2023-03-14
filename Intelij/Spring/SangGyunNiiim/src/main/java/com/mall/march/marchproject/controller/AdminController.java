package com.mall.march.marchproject.controller;

import com.mall.march.marchproject.dto.ItemDto;
import com.mall.march.marchproject.entity.Item;
import com.mall.march.marchproject.repository.ItemRepository;
import com.mall.march.marchproject.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Controller
@RequiredArgsConstructor
public class AdminController {

    private final ItemService itemService;

    @GetMapping("/toAdmin")
    public String toAdmin(Model model) {

       List<ItemDto> itemList =  itemService.selectAllItems();
       model.addAttribute("itemList", itemList);

        return "/mypage/admin/mypage-admin-main";
    }

}
