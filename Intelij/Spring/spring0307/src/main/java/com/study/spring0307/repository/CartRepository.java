package com.study.spring0307.repository;

import com.study.spring0307.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {

    List<Cart> findAllByOrderByIdDesc();

}