package com.example.study.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    private String userId;
    private String userPw;
    private String userNickname;
    private String userEmail;

    @OneToOne(mappedBy = "user")
    private UserImg userImg = new UserImg();

    @OneToOne(mappedBy = "user")
    private Board board = new Board();
}
