package com.carvajal.wishlistrestapi.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class UserResponseDto {
    private UUID userId;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
}
