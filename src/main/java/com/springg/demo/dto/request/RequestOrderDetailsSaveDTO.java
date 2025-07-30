package com.springg.demo.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class RequestOrderDetailsSaveDTO {
    private String itemName;
    private double qty;
    private double amount;
    private int order;
    private int itemId;

}
