package com.springg.demo.dto.reaponse;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemGetResponseDto {

    private int itemId;
    private String itemName;
    private double balanceQty;
    private double supplyPrice;
    private double sellingPrice;
    private boolean active;
}
