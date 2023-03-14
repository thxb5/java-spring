package com.mall.march.marchproject.dto;

import com.mall.march.marchproject.entity.User;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String user_id;
    private String user_password;
    private String user_address;
    private String user_email;
    private int user_point;
    private int is_admin;

    public static UserDto fromEntity(User user) {
        return UserDto.builder()
                .user_id(user.getUserId())
                .user_password(user.getUserPassword())
                .user_address(user.getUserAddress())
                .user_email(user.getUserEmail())
                .user_point(user.getUserPoint())
                .is_admin(user.getIsAdmin())
                .build();
    }
}
