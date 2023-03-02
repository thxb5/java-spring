package com.study.springboot.entity;

import java.util.ArrayList;
import java.util.List;
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
public class Genre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long gid;
	private String gname;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "genre", cascade = CascadeType.ALL)
	@ToString.Exclude
	private List<Detail> dList = new ArrayList<>();
	
	public void addDetail(Detail detail) {
		detail.setIdx(this.dList.size());
		detail.setGenre(this);
		dList.add(detail);
	}
}
