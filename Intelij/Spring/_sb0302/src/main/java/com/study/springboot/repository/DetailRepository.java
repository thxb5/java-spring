package com.study.springboot.repository;

import com.study.springboot.entity.Dept;
import org.springframework.data.jpa.repository.JpaRepository;

import com.study.springboot.entity.Detail;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DetailRepository extends JpaRepository<Detail, Long>{

    @Query(value = "select * from detail ", nativeQuery = true)
    public List<Detail> seleDtail();
}
