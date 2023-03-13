package com.example.study.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserImg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imgId;
    private String originName;
    private String saveName;
    private String savePath;

    @OneToOne
    @JsonIgnore
    private User user;
}
