package com.carvajal.wishlistrestapi.service;

import com.carvajal.wishlistrestapi.dto.ItemDto;
import com.carvajal.wishlistrestapi.mapper.ItemMapper;
import com.carvajal.wishlistrestapi.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ItemServiceImpl implements ItemService {

    private final ItemMapper itemMapper;
    private final ItemRepository itemRepository;

    @Override
    public List<ItemDto> findAllItems() {
        return itemMapper.itemsToItemDtos(itemRepository.findAll());
    }
}
