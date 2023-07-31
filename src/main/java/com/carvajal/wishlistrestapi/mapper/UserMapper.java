package com.carvajal.wishlistrestapi.mapper;

import com.carvajal.wishlistrestapi.dto.UserResponseDto;
import com.carvajal.wishlistrestapi.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponseDto userToUserResponseDto(User user);
    User userResponseDtoToUser(UserResponseDto userResponseDto);
}
