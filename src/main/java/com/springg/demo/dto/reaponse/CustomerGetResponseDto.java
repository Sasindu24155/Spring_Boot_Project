package com.springg.demo.dto.reaponse;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerGetResponseDto {

    private int customerId;
    private String customerName;
    private String customerAddress;
    private double customerSalary;
    private ArrayList customerNumber;
    private String customerNIC;
    private boolean active;
}
