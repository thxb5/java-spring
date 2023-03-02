package com.study.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.study.springboot.entity.Dept;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeptRepository
	extends JpaRepository<Dept, Integer> {

	@Modifying
	@Transactional
	@Query(value = "insert into Dept(deptno, dname, loc) values (:deptno, :dname, :loc) ", nativeQuery = true)
	public void insert(@Param("deptno") Integer deptno, @Param("dname") String dname, @Param("loc") String loc);



}
