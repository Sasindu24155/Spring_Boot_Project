package com.springg.demo.service;

import com.springg.demo.dto.CustomerDto;
import com.springg.demo.dto.reaponse.CustomerGetResponseDto;
import com.springg.demo.dto.request.CustomerUpdateDTO;

import java.util.List;


public interface CustomerService {
   public String saveCustomer(CustomerDto customerDto);

  String updateCustomer(CustomerUpdateDTO customerUpdateDto);


    CustomerDto getCustomerById(int customerId);

    List<CustomerDto> getAllCustomers();

    String deleteCustomer(int customerId);


  List<CustomerGetResponseDto> getAllCustomerByActiveState(boolean activeStatus);
}
