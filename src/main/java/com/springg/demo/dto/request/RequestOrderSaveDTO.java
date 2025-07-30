package com.springg.demo.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.springg.demo.entity.Customer;
import com.springg.demo.entity.OrderDetails;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class RequestOrderSaveDTO {
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate orderDate;
    private double totals;
    private Customer customer;
    private Set<OrderDetails> ordersDetails;
}
