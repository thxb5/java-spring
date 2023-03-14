package com.mall.march.marchproject.dto;

import com.mall.march.marchproject.entity.Item;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {
    private Long product_id;
    private int category_id;
    private String product_name;
    private int product_price;
    private String product_detail;
    private int product_amount;
    private Timestamp up_time;
    private Timestamp mod_time;


    Timestamp cur_time = new Timestamp(System.currentTimeMillis());
    public Item toEntity() {
       return Item.builder()
               .categoryId(category_id)
               .productName(product_name)
               .productPrice(product_price)
               .productDetail(product_detail)
               .productAmount(product_amount)
               .upTime(cur_time)
               .modTime(mod_time)
               .build();
    }

    public static ItemDto fromEntity(Item item) {
       return ItemDto.builder()
                .product_id(item.getProductId())
                .category_id(item.getCategoryId())
                .product_name(item.getProductName())
                .product_price(item.getProductPrice())
                .product_detail(item.getProductDetail())
                .product_amount(item.getProductAmount())
                .up_time(item.getUpTime())
                .mod_time(item.getModTime())
                .build();
    }
}
