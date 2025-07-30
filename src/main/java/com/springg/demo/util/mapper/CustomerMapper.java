package com.springg.demo.util.mapper;

import com.springg.demo.dto.reaponse.CustomerGetResponseDto;
import com.springg.demo.entity.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    List<CustomerGetResponseDto > entitiyListToDtoList (List<Customer>customers);
}
