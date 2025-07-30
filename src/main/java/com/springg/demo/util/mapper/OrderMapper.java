package com.springg.demo.util.mapper;

import com.springg.demo.dto.request.RequestOrderSaveDTO;
import com.springg.demo.entity.Order;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    List<RequestOrderSaveDTO> entitiyListToDtoList(List<Order>orders);


}
