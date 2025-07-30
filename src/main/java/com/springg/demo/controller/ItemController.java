package com.springg.demo.controller;


import com.springg.demo.dto.paginated.PaginatedResponseItemDto;
import com.springg.demo.dto.reaponse.ItemGetResponseDto;
import com.springg.demo.dto.request.ItemSaveDto;
import com.springg.demo.service.ItemService;
import com.springg.demo.util.StanderResponse;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping("/save")
    public ResponseEntity <StanderResponse>saveItem(@RequestBody ItemSaveDto itemDto) {
       String message = itemService.saveItem(itemDto);

        return new ResponseEntity<StanderResponse>(
                new StanderResponse(201,"Success",message),
                HttpStatus.CREATED
        );
    }

    @GetMapping(
            path = "/get-by-name",
            params = "name"
    )
    public List<ItemGetResponseDto> getItemByNameAndStatus(@RequestParam(value = "name") String itemName) {
        List<ItemGetResponseDto> itemDtoList = itemService.getItemByNameAndStatus(itemName);
        return itemDtoList;
    }

    @GetMapping(
            path = "/get-by-mapstruct",
            params = "name"
    )
    public List<ItemGetResponseDto> getItemByNameAndStatusByMapstruct(@RequestParam(value = "name") String itemName) {
        List<ItemGetResponseDto> itemDtoList = itemService.getItemByNameAndStatusByMapstruct(itemName);
        return itemDtoList;
    }

    @GetMapping(
            path = "/get-all-item-by-status",
            params ={"activeStatus", "page", "size"}
    )
    public ResponseEntity <StanderResponse> getItemByActiveStatues
            (@RequestParam(value = "activeStatus") boolean activeStatus,
             @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size
        ){
//        List<ItemGetResponseDto> itemDtoList = itemService.getItemByActiveStatues(activeStatus,page,size);
        PaginatedResponseItemDto paginatedResponseItemDto = itemService.getItemByActiveStatuesWithPaginated(activeStatus,page,size);
        return new ResponseEntity<StanderResponse>(
                new StanderResponse(201,"Success",paginatedResponseItemDto),
                HttpStatus.OK
        );
    }


}
