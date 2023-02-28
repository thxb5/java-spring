package com.study.springboot;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class MyBatis0208ApplicationTests {

	EmpDao empDao;
	
	@Autowired
	public MyBatis0208ApplicationTests(EmpDao empDao) {
		this.empDao = empDao;
	}

	@Test
	void contextLoads() {
	}
	
	@Test
	@DisplayName("emp_temp 리스트 테스트")
	public void testList() {
		List<Emp> list = empDao.list();
		log.info(list);
	}
	
	//@Test
	@DisplayName("emp_temp 쓰기 테스트")
	public void testWrite() {
//		Emp emp = new Emp();
//		emp.setEmpno(1215);
//		emp.setEname("김기사");
//		emp.setJob("사원");
//		emp.setSal(3500);
		
		//위 아래가 같은 표현이다,,
		Emp emp = Emp.builder().empno(5454)
				.ename("김사장").job("사장").sal(6400)
				.build();
		log.info(emp);
		int res = empDao.write(emp); //DB 성공하면 1
		assertThat(res).isEqualTo(1);
	}
	
	@Test
	@DisplayName("viewOne 테스트")
	public void testViewOne() {
		Emp emp = empDao.viewOne(5454);
		log.info(emp);
		assertThat(emp.getEmpno()).isEqualTo(5454);
	}
	
	@Test
	@DisplayName("emp_temp 수정 테스트")
	public void testUpdate() {
		Emp emp = Emp.builder().empno(5454)
				.ename("박부장").job("부장")
				.sal(5000).build();
		log.info(emp);
		int res = empDao.update(emp);
		Assertions.assertEquals(res, 1);
	}
	

}
