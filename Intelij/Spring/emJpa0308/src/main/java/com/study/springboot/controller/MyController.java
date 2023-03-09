package com.study.springboot.controller;

import com.study.springboot.entity.Cart;
import com.study.springboot.entity.Product;
import com.study.springboot.repository.CartRepository;
import com.study.springboot.repository.MyEntityManager;
import com.study.springboot.entity.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MyController {
    private final MyEntityManager em;
    private final CartRepository cartRepository;
    private final EntityManager em2;

    @GetMapping("/create")
    @ResponseBody
    public String create() {
        String str = em.create();
        return str;
    }

    @GetMapping("/update")
    @ResponseBody
    public String update() {
        String str = em.update();
        return str;
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

    @GetMapping("/getcart")
    @ResponseBody
    public Cart getCart() {
        Cart cart = em.getCart();
        return cart;
    }

    @GetMapping("/")
    public String index() {
        return "view/index";
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
        System.out.println("===>"+cart.getProducts());
        model.addAttribute("list", cart.getProducts());
        return "view/detail";
    }

    @GetMapping("/insert1")
    public String insert1() {
        String str = em.putInCart();
        System.out.println("===>"+str);
        return "redirect:/page2";
    }

    @GetMapping("/makeCart")
    @ResponseBody
    public Cart makeCart(HttpSession session) {
        Cart cart = new Cart();
        Product product = Product.builder().cart(cart).name("가방").price(70000).build();
        cart.addProduct(product);
        System.out.println("cart = " + cart);
        System.out.println("cart.getProducts() = " + cart.getProducts());
        session.setAttribute("sesCart",cart);
        return cart;
    }

    @GetMapping("/saveCart")
    @ResponseBody
    @Transactional
    public Cart saveCart(HttpSession session) {
        Cart cart = (Cart) session.getAttribute("sesCart");
        System.out.println("cart.getProducts() = " + cart.getProducts());
        em2.merge(cart);
        return cart;
    }

    @GetMapping("/delProduct")
    @ResponseBody
    @Transactional
    public Cart delProduct() {
//        Cart cart = em2.find(Cart.class, 2L);
//        System.out.println("cart.getProducts() = " + cart.getProducts());
//        em2.remove(cart.getProducts().get(0));
        Product product = em2.find(Product.class,8L);
        System.out.println("product = " + product);
        em2.remove(product);
        Cart cart = em2.find(Cart.class, 2L);
        return cart;
    }

} //Class
