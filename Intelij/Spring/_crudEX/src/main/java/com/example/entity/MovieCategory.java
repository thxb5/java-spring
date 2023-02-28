package com.example.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MovieCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long genreId;
    private String genreTitle;

//    @OneToMany(fetch = FetchType.EAGER,
//                mappedBy = "genre",
//                cascade = CascadeType.ALL)
//    @ToString.Exclude
//    private List<Movie> movieList = new ArrayList<>();

}
