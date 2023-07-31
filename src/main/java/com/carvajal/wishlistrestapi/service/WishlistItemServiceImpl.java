package com.carvajal.wishlistrestapi.service;

import com.carvajal.wishlistrestapi.dto.WishlistItemRequestDto;
import com.carvajal.wishlistrestapi.dto.WishlistItemResponseDto;
import com.carvajal.wishlistrestapi.dto.WishlistItemUpdateRequestDto;
import com.carvajal.wishlistrestapi.exception.ResourceNotFoundException;
import com.carvajal.wishlistrestapi.mapper.WishlistItemMapper;
import com.carvajal.wishlistrestapi.model.User;
import com.carvajal.wishlistrestapi.model.WishlistItem;
import com.carvajal.wishlistrestapi.repository.ItemRepository;
import com.carvajal.wishlistrestapi.repository.UserRepository;
import com.carvajal.wishlistrestapi.repository.WishlistItemRepository;
import com.carvajal.wishlistrestapi.util.MessageConstants;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class WishlistItemServiceImpl implements WishlistItemService {

    private final WishlistItemMapper wishlistItemMapper;
    private final WishlistItemRepository wishlistItemRepository;
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;

    @Override
    public WishlistItemResponseDto createWishlistItem(WishlistItemRequestDto wishlistItemRequestDto) {
        userRepository.findById(wishlistItemRequestDto.getUserId()).orElseThrow(() -> new ResourceNotFoundException(
                MessageConstants.RESOURCE_USER_NOT_FOUND.formatted(wishlistItemRequestDto.getUserId().toString())
        ));

        itemRepository.findById(wishlistItemRequestDto.getItemId()).orElseThrow(() -> new ResourceNotFoundException(
                MessageConstants.RESOURCE_ITEM_NOT_FOUND.formatted(wishlistItemRequestDto.getItemId().toString())
        ));

        return wishlistItemMapper.wishlistItemToWishlistItemResponseDto(
                wishlistItemRepository.save(
                        wishlistItemMapper.wishlistItemRequestDtoToWishlistItem(wishlistItemRequestDto)
                )
        );
    }

    public Set<WishlistItemResponseDto> getWishlistItemsByUserId(UUID userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException(
                MessageConstants.RESOURCE_USER_NOT_FOUND.formatted(userId.toString())
        ));

        Set<WishlistItem> enabledWishlistItems = user.getWishlistItems().stream()
                .filter(WishlistItem::isEnabled)
                .collect(Collectors.toSet());

        return wishlistItemMapper.wishlistItemsToWishlistItemResponseDto(enabledWishlistItems);
    }

    @Override
    public WishlistItemResponseDto updateWishlistItem(WishlistItemUpdateRequestDto wishlistItemUpdateRequestDto, UUID wishlistItemId) {
        WishlistItem wishlistItem = wishlistItemRepository.findById(wishlistItemId).orElseThrow(() -> new ResourceNotFoundException(
                MessageConstants.RESOURCE_WISHLIST_ITEM_NOT_FOUND.formatted(wishlistItemId.toString())
        ));
        wishlistItem.setNote(wishlistItemUpdateRequestDto.getNote());
        wishlistItem.setEnabled(wishlistItemUpdateRequestDto.isEnabled());
        return wishlistItemMapper.wishlistItemToWishlistItemResponseDto(wishlistItemRepository.save(wishlistItem));
    }
}
