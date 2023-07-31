package com.carvajal.wishlistrestapi.service;

import com.carvajal.wishlistrestapi.dto.WishlistItemRequestDto;
import com.carvajal.wishlistrestapi.dto.WishlistItemResponseDto;
import com.carvajal.wishlistrestapi.dto.WishlistItemUpdateRequestDto;

import java.util.Set;
import java.util.UUID;

public interface WishlistItemService {

    WishlistItemResponseDto createWishlistItem(WishlistItemRequestDto wishlistItemRequestDto);
    Set<WishlistItemResponseDto> getWishlistItemsByUserId(UUID userId);
    WishlistItemResponseDto updateWishlistItem(WishlistItemUpdateRequestDto wishlistItemUpdateRequestDto, UUID wishlistItemId);
}
