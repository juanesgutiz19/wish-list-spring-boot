package com.carvajal.wishlistrestapi.mapper;

import com.carvajal.wishlistrestapi.model.Item;
import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface ItemUUIDMapper {
    Item map(UUID itemId);
}
