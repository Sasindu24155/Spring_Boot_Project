package com.springg.demo.controller;

import com.springg.demo.dto.request.ItemSaveDto;
import com.springg.demo.dto.request.RequestOrderSaveDTO;
import com.springg.demo.repo.OrderRepo;
import com.springg.demo.service.OrderService;
import com.springg.demo.util.StanderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/save")
    public ResponseEntity<StanderResponse> saveOrder(@RequestBody RequestOrderSaveDTO requestOrderSaveDTO) {
        String message = orderService.addOrder(requestOrderSaveDTO);

        return new ResponseEntity<StanderResponse>(
                new StanderResponse(201,"Success",message),
                HttpStatus.CREATED
        );
    }
}
