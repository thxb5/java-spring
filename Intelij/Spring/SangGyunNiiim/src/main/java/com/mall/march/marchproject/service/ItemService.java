package com.mall.march.marchproject.service;

import com.mall.march.marchproject.dto.ItemDto;
import com.mall.march.marchproject.entity.Item;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public interface ItemService {

 List<ItemDto> selectAllItems();

 ItemDto selectOneItem(Long productId);


}
