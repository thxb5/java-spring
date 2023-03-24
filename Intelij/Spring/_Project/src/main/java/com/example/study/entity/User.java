package com.example.study.entity;

import lombok.*;

import javax.persistence.*;
import java.util.*;

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



}
