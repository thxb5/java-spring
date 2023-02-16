package com.study.springboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity  //필수
@Table(name="mydata")
@Builder //Outline에 static으로 표시됨,, 객체생성 할 필요가 없음
@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MyData {
	@Id  //필수
	//GenerationType을 identity로 하면 auto incre 효과와 같다
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(length = 50, nullable = false)
	private String name;
	@Column(length = 200, nullable = true)
	private String mail;
	private Integer age;
	@Column(nullable = true)
	private String memo;
}
