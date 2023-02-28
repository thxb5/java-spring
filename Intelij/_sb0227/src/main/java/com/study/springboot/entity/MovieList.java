package com.study.springboot.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@ToString
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="movieList")
public class MovieList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int kategorie;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idx;
	@Column(length = 50, nullable = false)
	private String title;
	@Column(length = 200, nullable = false)
	private String content;

	@ManyToOne
	@JoinColumn(name = "kategorie")
	private KategorieList kategorieList;
}
