package com.springg.demo.dto.paginated;

import com.springg.demo.dto.reaponse.ItemGetResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedResponseItemDto {
    List<ItemGetResponseDto> list;
    private long totalElements;
}
