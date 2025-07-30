package com.springg.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name="orders")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Order {

    @Id
    @Column(name="order_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    @Column(name = "order_date",length =100,nullable = false)
    private LocalDate orderDate;

    @Column(name = "total",length =100,nullable = false)
    private double totals;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy="order")
    private Set<OrderDetails> ordersDetails;

    public Order(LocalDate orderDate, double totals, Customer customer) {
        this.orderDate = orderDate;
        this.totals = totals;
        this.customer = customer;
    }
}
