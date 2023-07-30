package com.carvajal.wishlistrestapi.mapper;

import com.carvajal.wishlistrestapi.dto.ItemResponseDto;
import com.carvajal.wishlistrestapi.model.Item;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    ItemResponseDto itemToItemResponseDto(Item item);

    Item itemResponseDtoToItem(ItemResponseDto itemResponseDto);
    List<ItemResponseDto> itemsToItemResponseDtos(List<Item> items);

}
