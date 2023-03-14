package com.mall.march.marchproject.service;

import com.mall.march.marchproject.dto.ItemDto;
import com.mall.march.marchproject.entity.Item;
import com.mall.march.marchproject.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{

    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<ItemDto> selectAllItems() {

        List<Item> entityList = itemRepository.selectAllItems();
        // 엔티티를 담아서
        List<ItemDto> itemDtoList = new ArrayList<>();
        // DTO 담을 리스트

        for(Item item : entityList) {
            ItemDto itemDto = ItemDto.fromEntity(item);
            // 하나씩 DTO로 변환시켜서
            itemDtoList.add(itemDto);
            // 리스트에 저장
        }

        return itemDtoList;
    }

    @Override
    public ItemDto selectOneItem(Long productId) {
       ItemDto itemDto = ItemDto.fromEntity(itemRepository.findItemByProductId(productId));
       return itemDto;
    }

}
