package com.carvajal.wishlistrestapi.mapper;

import com.carvajal.wishlistrestapi.dto.WishlistItemRequestDto;
import com.carvajal.wishlistrestapi.dto.WishlistItemResponseDto;
import com.carvajal.wishlistrestapi.model.Item;
import com.carvajal.wishlistrestapi.model.User;
import com.carvajal.wishlistrestapi.model.WishlistItem;
import com.carvajal.wishlistrestapi.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.mapstruct.*;


@Mapper(componentModel = "spring", uses = {UserMapper.class, ItemMapper.class, ItemUUIDMapper.class, UserUUIDMapper.class})
public interface WishlistItemMapper {

    @Mappings({
            @Mapping(target = "wishlistItemsId", ignore = true),
            @Mapping(target = "user", source = "userId"),
            @Mapping(target = "item", source = "itemId"),
            @Mapping(target = "note", source = "note"),
            @Mapping(target = "addedDate", expression = "java(java.time.LocalDateTime.now())"),
            @Mapping(target = "enabled", source = "enabled")
    })
    WishlistItem wishlistItemRequestDtoToWishlistItem(WishlistItemRequestDto wishlistItemRequestDto);

    WishlistItemResponseDto wishlistItemToWishlistItemResponseDto(WishlistItem wishlistItem);

}
