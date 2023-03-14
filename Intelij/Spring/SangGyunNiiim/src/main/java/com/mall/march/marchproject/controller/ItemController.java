package com.mall.march.marchproject.controller;

import com.mall.march.marchproject.dto.ImgDto;
import com.mall.march.marchproject.dto.ItemDto;
import com.mall.march.marchproject.service.ImgService;
import com.mall.march.marchproject.service.ItemService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Log4j2
@Controller
public class ItemController {

    private final ItemService itemService;
    private final ImgService imgService;
    public ItemController(ItemService itemService, ImgService imgService) {
        this.itemService = itemService;
        this.imgService = imgService;
    }

//    @GetMapping("/toDetail")
//    public String toDetail() {
//        return "/item/itemdetail";
//    }

    @GetMapping("/toCart")
    public String toCart() {
        return "/cart/cart";
    }

    @GetMapping("/toItemList")
    public String toItemList(Model model) {
        List<ItemDto> itemList = itemService.selectAllItems();
        // 등록되어있는 모든 상품 추출
        model.addAttribute("itemList", itemList);
        return "/item/itemlist";
    }

    @GetMapping("/toDetail/{product_id}")
    public String test(@PathVariable("product_id") Long product_id, Model model) {
       ItemDto itemDto = itemService.selectOneItem(product_id);
       List<ImgDto> imgList = imgService.selectImgsByProductId(product_id);

       model.addAttribute("imgList", imgList);
       model.addAttribute("item", itemDto);
        // Repository에서 넘어온 product_id로 상품 Dto를 찾고, Detail 페이지에서 뿌려준다.
        // 사진, 이름, 가격, 재고, 설명, 카테고리 등등

        return "/item/itemdetail";
    }
}
