package com.sunny.green.vo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchVo extends PagingVO  {
//                    <option>회원명</option>
//                    <option>아이디</option>
//                    <option>전화번호</option>

    private String user_id;
    private String user_name;
    private String user_tel;



}
