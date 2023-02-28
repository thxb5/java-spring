package com.study.springboot;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.springboot.entity.Emp;
import com.study.springboot.entity.Master;
import com.study.springboot.entity.Slave;
import com.study.springboot.jdbc.EmpDeptMapper;
import com.study.springboot.repository.EmpRepository;
import com.study.springboot.repository.MasterRepository;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class Template0217ApplicationTests {

	@Autowired
	EmpDeptMapper empDeptMapper;
	
	@Autowired
	EmpRepository empRepository;

	@Autowired
	MasterRepository masterRepository;
	
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
	public void insertMasterSlave() {
		Master master = new Master();
		master.setCode("20");
		master.setComment("연습2");
		master.addSlave(Slave.builder().title("연습2")
						.content("이것은 연습2").build());
		master.addSlave(Slave.builder().title("연습3")
				.content("이것은 연습3").build());
		masterRepository.save(master);
		log.info(master.getMid());
	}
	
	@Test
	public void selectMasterSlave() {
		Master master = masterRepository
						.findById(3L).orElseThrow();
		List<Slave> slaveList = master.getSlaveList();
		log.info(slaveList);
	}
	

}
