package com.carvajal.wishlistrestapi.dto;

import lombok.Data;

@Data
public class WishlistItemUpdateRequestDto {
    private String note;
    private boolean enabled;
}
