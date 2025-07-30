package com.springg.demo.entity;

import com.springg.demo.entity.enums.MeasuringUnitType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name="item")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="item_id",length = 45)
    private int itemId;

    @Column(name = "item_name",length =100,nullable = false)
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name = "measur_type",length =100,nullable = false)
    private MeasuringUnitType measuringUnitType;

    @Column(name = "balance_qty",length =100,nullable = false)
    private double balanceQty;

    @Column(name = "supply_price",length =100,nullable = false)
    private double supplyPrice;

    @Column(name = "selling_price",length =100,nullable = false)
    private double sellingPrice;

    @Column(name = "active_state", columnDefinition = "TINYINT DEFAULT 0")
    private boolean active;

    @OneToMany(mappedBy="item")
    private Set<OrderDetails> orderDetails;
}
