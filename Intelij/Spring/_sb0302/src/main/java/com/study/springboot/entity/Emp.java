package com.study.springboot.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@ToString
public class Emp {
	@Id
	private Integer empno;
	private String ename;
	private String job;
	private Integer mgr;
	private String hiredate;
	private Integer sal;
	private Integer comm;
	private Integer deptno;
}
