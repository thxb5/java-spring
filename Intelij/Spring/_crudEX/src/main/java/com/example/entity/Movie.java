package com.example.entity;

import lombok.*;

import javax.persistence.*;

@Builder
@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;
    private String movieTitle;
    private String movieContent;
    private int movieKategorie;

//    @Column(name = "genre")
//    @ManyToOne(fetch = FetchType.LAZY)
//    public MovieCategory movieCategory;
}
