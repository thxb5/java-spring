package com.study.springboot;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmpMapper {
	
	@Select("select * from emp_temp")
	List<Emp> findAll();
}
