package com.study.springboot;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.springboot.jdbc.Dao;
import com.study.springboot.jdbc.ListDto;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class MyBatisExexApplicationTests {
	
	private Dao dao;
	
	//의존성 주입
	@Autowired
	public MyBatisExexApplicationTests(Dao dao) {
		this.dao = dao;
	}

	@Test
	void contextLoads() {
	}
	
	@Test
	@DisplayName("findAll 테스트")
	void testFindAll() {
		List<ListDto> lst = dao.findAll();
		log.info(lst);
	}
}
