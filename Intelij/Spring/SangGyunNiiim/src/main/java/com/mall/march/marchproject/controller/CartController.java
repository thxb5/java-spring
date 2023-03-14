package com.mall.march.marchproject.controller;

import com.mall.march.marchproject.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/addItemToCart")
    public String addToCart() {

        // 장바구니를 누르면 해당 상품의 엔티티가 수량만 변경되어 Cart DB에 저장된다.
        // Ajax로 비동기처리. 처리 후 뜨는 모달창에 장바구니로 이동할건지 쇼핑 더 할건지 선택버튼 구현
        // 장바구니에는 해당 유저가 장바구니에 담은 상품정보 출력, 총 가격정보 출력.

        return "";
    }
}
