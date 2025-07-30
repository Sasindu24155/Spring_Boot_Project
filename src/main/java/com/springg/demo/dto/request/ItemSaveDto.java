package com.springg.demo.dto.request;


import com.springg.demo.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemSaveDto {
    private String itemName;
    private MeasuringUnitType measuringUnitType;
    private double balanceQty;
    private double supplyPrice;
    private double sellingPrice;


}



