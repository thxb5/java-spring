package com.mall.march.marchproject.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StockDto {
    private int stock_id;
    private int product_id;
    private int product_amount;
    private String type;
    //입고 혹은 출고

}
