package com.carvajal.wishlistrestapi.service;

import com.carvajal.wishlistrestapi.dto.WishlistItemRequestDto;
import com.carvajal.wishlistrestapi.dto.WishlistItemResponseDto;

public interface WishlistItemService {

    WishlistItemResponseDto createWishlistItem(WishlistItemRequestDto wishlistItemRequestDto);
}
