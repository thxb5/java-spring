package com.study.springboot.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Poster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ino;
	private String name;
	private int idx;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Movie movie;
	
}
