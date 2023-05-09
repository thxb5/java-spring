package com.study.springboot;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class Emp {
	private int empno;
	private String ename;
	private String job;
	private int sal;
	
}
