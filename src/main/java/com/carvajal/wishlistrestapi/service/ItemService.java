package com.carvajal.wishlistrestapi.service;

import com.carvajal.wishlistrestapi.dto.ItemResponseDto;

import java.util.List;

public interface ItemService {

    List<ItemResponseDto> findAllItems();
}
