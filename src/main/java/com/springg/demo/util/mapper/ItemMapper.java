package com.springg.demo.util.mapper;

import com.springg.demo.dto.reaponse.ItemGetResponseDto;
import com.springg.demo.dto.request.RequestOrderSaveDTO;
import com.springg.demo.entity.Item;
import com.springg.demo.entity.Order;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper  {
    List<ItemGetResponseDto> entitiyListToDtoList(List<Item>items);

    List<ItemGetResponseDto>ListDtoToPage(Page<Item>items);

}

