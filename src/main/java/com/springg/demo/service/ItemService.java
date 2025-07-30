package com.springg.demo.service;

import com.springg.demo.dto.paginated.PaginatedResponseItemDto;
import com.springg.demo.dto.reaponse.ItemGetResponseDto;
import com.springg.demo.dto.request.ItemSaveDto;

import java.util.List;

public interface ItemService {
    String saveItem(ItemSaveDto itemDto);

    List<ItemGetResponseDto> getItemByNameAndStatus(String itemName);

    List<ItemGetResponseDto> getItemByNameAndStatusByMapstruct(String itemName);

    List<ItemGetResponseDto> getItemByActiveStatues(boolean activeStatus);

    PaginatedResponseItemDto getItemByActiveStatuesWithPaginated(boolean activeStatus, int page, int size);
}
