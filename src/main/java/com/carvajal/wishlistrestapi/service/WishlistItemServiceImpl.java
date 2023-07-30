package com.carvajal.wishlistrestapi.service;

import com.carvajal.wishlistrestapi.dto.WishlistItemRequestDto;
import com.carvajal.wishlistrestapi.dto.WishlistItemResponseDto;
import com.carvajal.wishlistrestapi.mapper.WishlistItemMapper;
import com.carvajal.wishlistrestapi.repository.WishlistItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class WishlistItemServiceImpl implements WishlistItemService {

    private final WishlistItemMapper wishlistItemMapper;
    private final WishlistItemRepository wishlistItemRepository;

    @Override
    public WishlistItemResponseDto createWishlistItem(WishlistItemRequestDto wishlistItemRequestDto) {
        return wishlistItemMapper.wishlistItemToWishlistItemResponseDto(
                wishlistItemRepository.save(
                        wishlistItemMapper.wishlistItemRequestDtoToWishlistItem(wishlistItemRequestDto)
                )
        );
    }
}
