package com.mall.march.marchproject.entity;

import com.mall.march.marchproject.dto.UserDto;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.thymeleaf.util.StringUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String userId;
    @Column(nullable = false)
    private String userPassword;
    @Column(nullable = false)
    private String userAddress;
    @Column(nullable = false)
    private String userEmail;
    private int userPoint = 0;
    private int isAdmin = 1;

    public boolean isNull(User user) {
        if(StringUtils.isEmpty(user.getUserId()) || StringUtils.isEmpty(user.getUserPassword())) {
            return false;
        }
        return true;
    }

}
