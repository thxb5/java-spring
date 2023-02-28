package com.study.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface EmpMapper {
	@Select("select empno, ename, job, sal from emp_temp")
	List<Emp> findAll();
	
	@Select("select empno, ename, job, sal from emp_temp where empno=#{empno}")
	Emp selectOne(int empno);
	
	@Insert("INSERT INTO emp_temp(empno, ename, job, sal)"
			+ " values(#{empno}, #{ename}, #{job}, #{sal})")
	int save(Emp emp);
	
	@Delete("Delete from emp_temp where empno=#{empno}")
	int delete(int empno);
	
	@Update("Update emp_temp set empno=#{newEmpno}, ename=#{ename}, job=#{job}, sal=#{sal} "
			+ "where empno=#{empno}")
	int update(Emp emp);
	
}
