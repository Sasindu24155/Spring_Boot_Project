package com.springg.demo.service.impl;

import com.springg.demo.dto.CustomerDto;
import com.springg.demo.dto.reaponse.CustomerGetResponseDto;
import com.springg.demo.dto.request.CustomerUpdateDTO;
import com.springg.demo.entity.Customer;
import com.springg.demo.exception.NotFoundException;
import com.springg.demo.repo.CustomerRepo;
import com.springg.demo.service.CustomerService;
import com.springg.demo.util.mapper.CustomerMapper;
import com.springg.demo.util.mapper.ItemMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceIMPL implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public String saveCustomer(CustomerDto customerDto) {
        Customer customer = modelMapper.map(customerDto, Customer.class);

        if (!customerRepo.existsById(customer.getCustomerId())) {
            customerRepo.save(customer);
             return customer.getCustomerId() + " Saved Successfully";
        } else {
            throw new DuplicateKeyException("This customer is already added");
        }
    }

    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDto) {
        Customer customer = modelMapper.map(customerUpdateDto, Customer.class);
        if (customerRepo.existsById(customerUpdateDto.getCustomerId())) {
            customerRepo.save(customer);
            return customerUpdateDto.getCustomerName() + " update success";

        } else {
            throw new RuntimeException("No data found that file");
        }
    }

//    @Override
//    public String updateCustomer(CustomerUpdateDTO customerUpdateDto) {
//        if (customerRepo.existsById(customerUpdateDto.getCustomerId())) {
//            Customer customer = customerRepo.getReferenceById(customerUpdateDto.getCustomerId());
//            customer.setCustomerName(customerUpdateDto.getCustomerName());
//            customer.setCustomerAddress(customerUpdateDto.getCustomerAddress());
//            customer.setCustomerSalary(customerUpdateDto.getCustomerSalary());
//
//            customerRepo.save(customer);
//            return customerUpdateDto.getCustomerName() + " update success";
//
//        } else {
//            throw new RuntimeException("No data found that file");
//        }
//    }

    @Override
    public CustomerDto getCustomerById(int customerId) {
        if (customerRepo.existsById(customerId)) {
            Customer customer = customerRepo.getReferenceById(customerId);
            CustomerDto customerDto = new CustomerDto(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerSalary(),
                    customer.getCustomerNumber(),
                    customer.getCustomerNIC(),
                    customer.isActive()
            );

            return customerDto;

        } else {
            throw new RuntimeException("No data found");
        }

    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> getAllCustomers = customerRepo.findAll();
        if (getAllCustomers.size() > 0) {
            List<CustomerDto> customerDtoList = new ArrayList<>();

            for (Customer customer : getAllCustomers) {
                CustomerDto customerDto = new CustomerDto(
                        customer.getCustomerId(),
                        customer.getCustomerName(),
                        customer.getCustomerAddress(),
                        customer.getCustomerSalary(),
                        customer.getCustomerNumber(),
                        customer.getCustomerNIC(),
                        customer.isActive()
                );
                customerDtoList.add(customerDto);

            }
            return customerDtoList;
        } else {
        }
        throw new NotFoundException( "No Found data");
    }



    @Override
    public String deleteCustomer(int customerId) {
        if (customerRepo.existsById(customerId)) {
            customerRepo.deleteById(customerId);
            return "Deleted successfully: " + customerId;
        } else {
            throw new RuntimeException("No data found for ID: " + customerId);
        }
    }

    @Override
    public List<CustomerGetResponseDto> getAllCustomerByActiveState(boolean activeStatus) {
        List<Customer> customers = customerRepo.findAllByActive(activeStatus);
        if (!customers.isEmpty()) {
            List<CustomerGetResponseDto> customerGetResponseDtos = customerMapper.entitiyListToDtoList(customers) ;
            return customerGetResponseDtos;
        } else {
            throw new RuntimeException("Item is not Active");
        }
    }
}



