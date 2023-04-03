package com.example.study.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BoardImg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bd_img_id;
    private String bd_origin_name;
    private String bd_save_name;
    private String bd_img_path;

    @OneToOne
    @JoinColumn(name = "bd_no")
    @JsonIgnore
    private Board board;


}
