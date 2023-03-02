package com.study.springboot.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Notice {
    @Id
    private Long seq;
    private String title;
    private String content;

}
