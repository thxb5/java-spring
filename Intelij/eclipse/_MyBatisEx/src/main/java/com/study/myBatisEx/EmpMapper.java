package com.study.myBatisEx;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface EmpMapper {

	@Select("select empno, ename, job, sal from emp_temp")
	List<Emp> selectEmpTempAll();
	
	@Select("select empno, ename, job, sal from emp_temp where empno = #{ empno }")
	List<Emp> selectEmpTemp(int empno);
	
	@Insert("insert into emp_temp(empno, ename, job, sal) "
			+ "values(#{empno}, #{ename}, #{job}, #{sal} )")
	int insertEmpTemp(Emp emp);
	
	@Update("update emp_temp set "
			+ "ename = #{ename}, "
			+ "job = #{job}, "
			+ "sal = #{sal} "
			+ "where empno = #{empno}")
	int updateEmpTemp(Emp emp);
	
	@Delete("delete from emp_temp where empno = #{empno}")
	int deleteEmpTemp(int empno);
}
