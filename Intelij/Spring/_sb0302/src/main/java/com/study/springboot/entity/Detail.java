package com.study.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@ToString
public class Detail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long did;
	private String title;
	private String content;
	private Integer idx;

	@ManyToOne(fetch = FetchType.LAZY)
	@ToString.Exclude
	private Genre genre;

}
