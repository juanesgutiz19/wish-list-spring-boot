package com.carvajal.wishlistrestapi.service;

import com.carvajal.wishlistrestapi.dto.ItemDto;

import java.util.List;

public interface ItemService {

    List<ItemDto> findAllItems();
}
