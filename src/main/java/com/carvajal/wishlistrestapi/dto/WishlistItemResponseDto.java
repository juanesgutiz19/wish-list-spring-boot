package com.carvajal.wishlistrestapi.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class WishlistItemResponseDto {
    private UUID wishlistItemsId;
    private UserResponseDto user;
    private ItemResponseDto item;
    private String note;
    private LocalDateTime addedDate;
    private boolean enabled;
}
