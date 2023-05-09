package com.study.springboot;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.springboot.entity.Emp;
import com.study.springboot.entity.Product;
import com.study.springboot.entity.ProductDetail;
import com.study.springboot.jdbc.EmpDeptMapper;
import com.study.springboot.repository.EmpRepository;
import com.study.springboot.repository.ProductDetailRepository;
import com.study.springboot.repository.ProductRepository;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class Template0217ApplicationTests {

	@Autowired
	EmpDeptMapper empDeptMapper;
	
	@Autowired
	EmpRepository empRepository;
	
	@Autowired
	ProductRepository productRepository;

	@Autowired
	ProductDetailRepository productDetailRepository;
	
	@Test
	void contextLoads() {
	}
	@Test
	@Disabled
	public void testMyBatisFindAllEmp() {
		List<Emp> list 
		= empDeptMapper.findAllEmp("78", "S");
		log.info(list);
	}

	@Test
	@Disabled
	public void testInsProduct() {
		Product product = Product.builder().name("책3").price(25000).stock(50).build();
		ProductDetail pd = ProductDetail.builder().content("조금 좋은 책").build();
//		product.setProductDetail(pd);
//		productRepository.save(product);
		pd.setProduct(product);
		productDetailRepository.save(pd);
	}
	
	@Test
	public void testSelectProduct() { 
		Product product = productRepository.findById(2L).orElseThrow();
		//2L은 product의 2번 자료를 뜻함. Long형 떄문에 L을 붙임
		log.info(product);
		log.info(product.getProductDetail());
	}
	
}
