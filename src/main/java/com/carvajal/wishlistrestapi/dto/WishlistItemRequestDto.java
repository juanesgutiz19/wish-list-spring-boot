package com.carvajal.wishlistrestapi.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class WishlistItemRequestDto {
    private UUID userId;
    private UUID itemId;
    private String note;
    private boolean enabled;
}
