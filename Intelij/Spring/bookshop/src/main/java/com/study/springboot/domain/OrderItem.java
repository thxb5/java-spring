package com.study.springboot.domain;

import com.study.springboot.domain.item.Item;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderItem {

    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)  // 얘도 양방향말고 단방향하면 안되나..? 오더에만 주문아이템 들어가게.- 아니다.오더가 생성되어야
    @JoinColumn(name = "order_id")
    private Order order;

    private int order_price; // 주문 가격 - 할인 받을 수도 있으므로
    private int count; // 주문 수량

}
