package com.carvajal.wishlistrestapi.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class ItemDto {
    private UUID itemId;
    private String label;
    private String description;
    private BigDecimal price;
    private int stockQuantity;

}
