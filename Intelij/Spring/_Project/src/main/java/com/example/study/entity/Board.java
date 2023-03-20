package com.example.study.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bdNo;
    private int bdList;
    private int bdPrice;
    private String bdTitle;
    private String bdContent;

    @OneToOne
    @JsonIgnore
    private User user;
}
