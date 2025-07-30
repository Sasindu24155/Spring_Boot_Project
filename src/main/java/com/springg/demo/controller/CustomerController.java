package com.springg.demo.controller;

import com.springg.demo.dto.CustomerDto;
import com.springg.demo.dto.reaponse.CustomerGetResponseDto;
import com.springg.demo.dto.request.CustomerUpdateDTO;
import com.springg.demo.service.CustomerService;
import com.springg.demo.service.impl.CustomerServiceIMPL;
import com.springg.demo.util.StanderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    private CustomerService customerService;

//    @PostMapping("/save")
//    public String saveCustomer(@RequestBody CustomerDto customerDto) {
//        CustomerServiceIMPL customerServiceIMPL= new CustomerServiceIMPL();
//        customerServiceIMPL.saveCustomer(customerDto);
//        customerService.saveCustomer(customerDto);
//        return "saved";
//    }
@PostMapping("/save")
public ResponseEntity<StanderResponse> saveCustomer(@RequestBody CustomerDto customerDto) {
    String dd = customerService.saveCustomer(customerDto);
    return new ResponseEntity<StanderResponse>(
            new StanderResponse(201,"Success",dd),
            HttpStatus.CREATED
    );
}

    @PutMapping("/update")
    public String updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDto) {
        String message = customerService.updateCustomer(customerUpdateDto);
        return message;
    }

    @GetMapping(
            path = "/get-by-id",
            params = "id"
    )
    public CustomerDto getCustomerByID(@RequestParam(value = "id") int customerId) {
        CustomerDto customerDTO = customerService.getCustomerById(customerId);
        return customerDTO;
    }
    @GetMapping(
            path = "/get-all-customer"
    )
    public ResponseEntity<StanderResponse> getAllCustomer(){
        List<CustomerDto> allCUstomer = customerService.getAllCustomers();
        return new ResponseEntity<StanderResponse>(
                new StanderResponse(200,"Success",allCUstomer),
                HttpStatus.OK
        );
    }
    @DeleteMapping(
            path = "/delete-customer/{id}"
    )
    public String deleteCustomer(@PathVariable(value = "id")int customerId){
        String deleted =customerService.deleteCustomer(customerId);
        return "deleted "+ customerId;
    }
    @GetMapping(path = "/get-all-customer-by-active-state/{status}")
    public ResponseEntity<StanderResponse> getAllCustomerByActiveState(@PathVariable(value = "status") boolean activeStatus) {
        List<CustomerGetResponseDto> customerDTO = customerService.getAllCustomerByActiveState(activeStatus);
        return new ResponseEntity<StanderResponse>(
                new StanderResponse(201,"Success",customerDTO),
                HttpStatus.CREATED
        );
    }

}


