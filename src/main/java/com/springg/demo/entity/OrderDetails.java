package com.springg.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="orderDetails")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class OrderDetails {
    @Id
    @Column(name="order_detail_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderDetailId;

    @Column(name = "item_name",length =100,nullable = false)
    private String itemName;

    @Column(name = "qty",length =100,nullable = false)
    private double qty;

    @Column(name = "amount",length =100,nullable = false)
    private double amount;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;



}
