package com.study.springboot;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.springboot.dao.Emp;
import com.study.springboot.dao.EmpMapper;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class MyBatis0207ApplicationTests {
	
	//필드에 하는 방식
	//@Autowired
	EmpMapper empMapper;
	
	//생성자 주입 방식
	@Autowired
	public MyBatis0207ApplicationTests(EmpMapper empMapper) {
		this.empMapper = empMapper;
	}

	//세터로 하는 방식
//	@Autowired
//	public void setEmpMapper(EmpMapper empMapper) {
//		this.empMapper = empMapper;
//	}

	@Test
	void contextLoads() {
	}
	
	@Test
	void test() {
		log.info("**************");
		assertThat("aaa").isEqualTo("aaa");
		Emp emp = empMapper.selectOne(1234);
		log.info(emp);
	}

}
