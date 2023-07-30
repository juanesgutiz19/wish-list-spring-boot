package com.carvajal.wishlistrestapi.mapper;

import com.carvajal.wishlistrestapi.dto.ItemDto;
import com.carvajal.wishlistrestapi.model.Item;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    ItemDto itemToItemDto(Item item);
    List<ItemDto> itemsToItemDtos(List<Item> items);

}
