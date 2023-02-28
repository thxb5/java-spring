package com.study.springboot;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface EmpDao {
	public List<Emp> list();
	public int write(Emp emp);
	public Emp viewOne(int empno);
	public int update(Emp emp);
	
	
}
