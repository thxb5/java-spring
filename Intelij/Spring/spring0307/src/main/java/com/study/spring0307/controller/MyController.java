package com.study.spring0307.controller;

import com.study.spring0307.entity.Cart;
import com.study.spring0307.entity.Person;
import com.study.spring0307.repository.CartRepository;
import com.study.spring0307.repository.MyEntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MyController {
    private final MyEntityManager em;
    private final CartRepository cartRepository;

    @GetMapping("/")
    public String index() {
        return "view/index";
    }

    @GetMapping("/create")
    @ResponseBody
    public String create() {
        String str = em.create();
        return str;
    }

    @GetMapping("/update")
    @ResponseBody
    public String update() {
        String aa = em.update();
        return aa;
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Person> list() {
        List<Person> list = em.selectAll();
        return list;
    }

    @GetMapping("/delete")
    @ResponseBody
    public String delete() {
        String str = em.delete();
        return str;
    }

    @GetMapping("/cart")
    @ResponseBody
    public String cart() {
        String str = em.putInCart();
        return str;
    }

    @GetMapping("/getCart")
    @ResponseBody
    public Cart getCert() {
        Cart cart = em.getCart();
        return cart;
    }

    @GetMapping("/page2")
    public String listAction(Model model, @PageableDefault(page = 0, size = 10) Pageable pageable) {
        //List<Notice> list = noticeRepository.findAll();
        List<Cart> list = cartRepository.findAllByOrderByIdDesc();
        final int start = (int) pageable.getOffset();
        final int end = Math.min((start + pageable.getPageSize()), list.size());
        final Page<Cart> page = new PageImpl<>(list.subList(start, end), pageable, list.size());
        model.addAttribute("list", page);
        return "view/list";
    }

    @GetMapping("/detail")
    public String detail(Long id, Model model) {
        Cart cart = em.getCart2(id);
        System.out.println("cart.getProducts() = " + cart.getProducts());
        model.addAttribute("list", cart.getProducts());
        return "view/detail";
    }

    @GetMapping("/insert1")
    public String insert1() {
        String str = em.putInCart();
        System.out.println("str = " + str);
        return "redirect:/page2";
    }

}//Class
