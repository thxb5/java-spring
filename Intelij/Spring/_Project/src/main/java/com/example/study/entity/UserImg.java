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
public class UserImg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long u_imgId;
    private String u_origin_name;
    private String u_save_name;
    private String u_userimg_path;

    @OneToOne
    @JsonIgnore
    private User user;

}
