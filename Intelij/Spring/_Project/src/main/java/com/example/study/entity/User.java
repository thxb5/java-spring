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
    private String user_id;
    private String user_pw;
    private String user_nickname;
    private String user_email;

}
