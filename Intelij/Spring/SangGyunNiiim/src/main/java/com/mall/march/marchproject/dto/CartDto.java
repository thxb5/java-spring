package com.mall.march.marchproject.dto;

import com.mall.march.marchproject.entity.Cart;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {

    private Long cart_id;
    private Long product_id;
    private String user_id;
    private int product_amount;

    public Cart toEntity() {
        return Cart.builder()
                .cartId(cart_id)
                .productId(product_id)
                .userId(user_id)
                .productAmount(product_amount)
                .build();
    }

    public static CartDto fromEntity(Cart cart) {
        return CartDto.builder()
                .cart_id(cart.getCartId())
                .product_id(cart.getProductId())
                .user_id(cart.getUserId())
                .product_amount(cart.getProductAmount())
                .build();
    }
}
