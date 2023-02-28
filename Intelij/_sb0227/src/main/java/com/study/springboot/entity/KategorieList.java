package com.study.springboot.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name="kategorieList")
public class KategorieList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int kategorie;
    private String name;

    @OneToMany(mappedBy = "kategorieList")
    List<MovieList> movieList = new ArrayList<>();


}
