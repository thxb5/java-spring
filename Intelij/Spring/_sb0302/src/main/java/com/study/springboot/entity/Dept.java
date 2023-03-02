package com.study.springboot.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Dept {
	@Id
	private Integer deptno;
	private String dname;
	private String loc;
}
