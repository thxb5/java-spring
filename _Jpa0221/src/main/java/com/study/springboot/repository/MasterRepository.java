package com.study.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.springboot.entity.Master;

public interface MasterRepository extends JpaRepository<Master, Long>{
	
}
