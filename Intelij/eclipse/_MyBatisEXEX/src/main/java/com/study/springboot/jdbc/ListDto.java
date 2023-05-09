package com.study.springboot.jdbc;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ListDto {
	private int list_num;
	private String title;
	private String content;
}
