package com.example.demo.jdbc;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.MovieList;

@Mapper
public interface MovieMapper {
	
	@Insert("insert into movielist(title,content,kategorie) values(#{title},#{content},#{kategorie}")
	public void insert(MovieList movieList);
}
