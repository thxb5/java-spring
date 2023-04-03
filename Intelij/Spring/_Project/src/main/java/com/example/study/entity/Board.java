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
    private Long bd_no;
    private int bd_list;
    private int bd_price;
    private String bd_title;
    private String bd_content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    private BoardImg boardImg; //BoardImg의 참조를 보관

    public void setBoardImg(BoardImg boardImg) {
        this.boardImg = boardImg;
    }

}
