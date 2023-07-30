package com.carvajal.wishlistrestapi.mapper;

import com.carvajal.wishlistrestapi.model.User;
import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface UserUUIDMapper {
    User map(UUID userId);
}
