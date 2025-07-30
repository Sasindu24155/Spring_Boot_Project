package com.springg.demo.service.impl;

import com.springg.demo.dto.request.RequestOrderSaveDTO;
import com.springg.demo.entity.Item;
import com.springg.demo.entity.Order;
import com.springg.demo.entity.OrderDetails;
import com.springg.demo.repo.CustomerRepo;
import com.springg.demo.repo.ItemRepo;
import com.springg.demo.repo.OrderDetailsRepo;
import com.springg.demo.repo.OrderRepo;
import com.springg.demo.service.OrderService;
import com.springg.demo.util.mapper.ItemMapper;
import com.springg.demo.util.mapper.OrderMapper;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderServiceIMPL implements OrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private OrderDetailsRepo orderDetailsRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private ItemRepo itemRepo;


    @Override
    @Transactional
    public String addOrder(RequestOrderSaveDTO requestOrderSaveDTO) {
        Order order = new Order(
                requestOrderSaveDTO.getOrderDate(),
                requestOrderSaveDTO.getTotals(),
                customerRepo.getById(requestOrderSaveDTO.getCustomer().getCustomerId())
        );
        orderRepo.save(order);

        List<OrderDetails> orderDetailsList = requestOrderSaveDTO.getOrdersDetails().stream()
                .map(dto -> {
                    OrderDetails details = new OrderDetails();
                    details.setOrder(order); // set FK
                    details.setItemName(dto.getItemName());
                    details.setQty(dto.getQty());
                    details.setAmount(dto.getAmount());

                    Item item = itemRepo.findById(dto.getItem().getItemId())
                            .orElseThrow(() -> new RuntimeException("Item not found with ID: " + dto.getItem()));
                    details.setItem(item);

                    return details;
                })
                .collect(Collectors.toList());

        // 3. Save all order details
        orderDetailsRepo.saveAll(orderDetailsList);

        return "Saved";
    }
}