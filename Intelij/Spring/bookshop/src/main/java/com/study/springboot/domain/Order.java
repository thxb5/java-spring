package com.study.springboot.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "orders") // 테이블명으로 order 못 써서
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    private LocalDateTime order_date;

    @ManyToOne(fetch = FetchType.LAZY)  // One으로 끝나는 건 기본이 EAGER라서 (fetch = FetchType.LAZY) 로 바꿔줘야 함.
    @JoinColumn(name = "member_id")
    private Member member;

    // Order가 Delivery를 관리하고 Order가 OrderItem을 관리할 때. 요 그림에서 cascade씀. - 참조하는 주인이 private 오너인 경우에만 씀 - Delivery랑 OrderItem은 Order만 참조해서 쓴다.
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY,  cascade = CascadeType.ALL) // cascade = CascadeType.ALL 한 이유 정리.
    // OneToOne 관계에서 외래키를 어디다 두느냐를 선택해야 하는데 보통 조회를 많이 하는 곳에 둔다 ( 이 경우 주문들어가서 배송을 보고 배송보고 주문들어갈 일이 없으므로 외래키를 Order테이블에 둔다, 연관관계 주인도 외래키가 있는 Order)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    private LocalDateTime orders_date;  // 주문 시간

    @Enumerated(EnumType.STRING)
    private OrderStatus status;   // 주문 상태



}