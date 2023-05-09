package com.study.springboot;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.springboot.entity.MyData;
import com.study.springboot.repository.MyDataRepository;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class Jpa0215ApplicationTests {

	@Autowired
	MyDataRepository myDataRepository;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	@DisplayName("insert 테스트")
	@Disabled
	public void insertTest() {
		IntStream.rangeClosed(1, 10).forEach(t-> {
			MyData myData = MyData.builder().memo("테스트"+t).build();
			log.info(myData);
			myDataRepository.save(myData);
		});
	}

	@Test
	@DisplayName("select 테스트")
	public void selectAllTest() {
		List<MyData> list = myDataRepository.findAll();
		list.stream().forEach(i -> {
			log.info(list);
		});
	}
	
	@Test
	@Disabled
	public void updateTest() {
		MyData mydata = MyData.builder().id(10L).memo("연습").build();
		log.info(myDataRepository.save(mydata));
	}
	
	@Test
	@Disabled
	public void deleteTest() {
		myDataRepository.deleteById(6L);
	}
	
	@Test
	public void selectOneTest() {
		//MyData mydata = myDataRepository.getOne(10L);
		MyData none = MyData.builder().memo("없음").build();
		Optional<MyData> mydata = myDataRepository.findById(12L);
		//optional은 null 체크를 위해서 사용한다,,
		log.info(mydata.orElse(none).getMemo());
	}
	
}//test
