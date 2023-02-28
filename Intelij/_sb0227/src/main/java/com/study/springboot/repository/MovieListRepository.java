package com.study.springboot.repository;

import com.study.springboot.entity.MovieList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieListRepository extends JpaRepository<MovieList, Integer> {

}
