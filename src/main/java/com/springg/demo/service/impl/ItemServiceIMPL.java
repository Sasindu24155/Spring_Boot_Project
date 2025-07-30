package com.springg.demo.service.impl;

import com.springg.demo.dto.paginated.PaginatedResponseItemDto;
import com.springg.demo.dto.reaponse.ItemGetResponseDto;
import com.springg.demo.dto.request.ItemSaveDto;
import com.springg.demo.entity.Item;
import com.springg.demo.exception.NotFoundException;
import com.springg.demo.repo.ItemRepo;
import com.springg.demo.service.ItemService;
import com.springg.demo.util.mapper.ItemMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Pageable;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ItemServiceIMPL implements ItemService {
    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemMapper itemMapper;


    @Override
    public String saveItem(ItemSaveDto itemDto) {
        Item item = modelMapper.map(itemDto, Item.class);

        if (!itemRepo.existsById(item.getItemId())) {
            itemRepo.save(item);
            return item.getItemId() + "Saved";
        } else
            throw new DuplicateKeyException("Its item already added");

    }

    @Override
    public List<ItemGetResponseDto> getItemByNameAndStatus(String itemName) {
        boolean b = true;
        List<Item> items = itemRepo.findAllByItemNameEqualsAndActive(itemName, b);
        if (items.size() > 0) {
            List<ItemGetResponseDto> itemGetResponseDtos = modelMapper.map(items, new TypeToken<List<ItemGetResponseDto>>() {
            }.getType());
            return itemGetResponseDtos;
        } else {
            throw new RuntimeException("Item is not Active");
        }

    }

    @Override
    public List<ItemGetResponseDto> getItemByNameAndStatusByMapstruct(String itemName) {
        boolean b = true;
        List<Item> items = itemRepo.findAllByItemNameEqualsAndActive(itemName, b);
        if (items.size() > 0) {
            List<ItemGetResponseDto> itemGetResponseDtos =itemMapper.entitiyListToDtoList(items);

            return itemGetResponseDtos;
        } else {
            throw new RuntimeException("Item is not Active");
        }

    }

    @Override
    public List<ItemGetResponseDto> getItemByActiveStatues(boolean activeStatus) {
        boolean b = true;
        List<Item> items = itemRepo.findAllByActive(activeStatus);
        if (items.size() > 0) {
            List<ItemGetResponseDto> itemGetResponseDtos =itemMapper.entitiyListToDtoList(items);

            return itemGetResponseDtos;
        } else {
            throw new RuntimeException("Item is not Active");
        }
    }

    @Override
    public PaginatedResponseItemDto getItemByActiveStatuesWithPaginated(boolean activeStatus, int page, int size) {
        Page<Item> items = itemRepo.findAllByActive(activeStatus, PageRequest.of(page, size));
        long count =itemRepo.countAllByActive(activeStatus);
        if (items.isEmpty()) {
            throw new NotFoundException("No data found");
        }
        PaginatedResponseItemDto paginatedResponseItemDto = new PaginatedResponseItemDto(
                itemMapper.ListDtoToPage(items),
                count
        );
        return paginatedResponseItemDto;

        }
    }
