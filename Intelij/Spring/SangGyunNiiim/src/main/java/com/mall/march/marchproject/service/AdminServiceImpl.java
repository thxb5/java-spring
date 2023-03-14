package com.mall.march.marchproject.service;

import com.mall.march.marchproject.entity.Item;
import com.mall.march.marchproject.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService{

    private final ItemRepository itemRepository;
    @Override
    public List<Item> selectList() {
        List<Item> list =  itemRepository.selectAllItems();
        // 모든 상품 추출
        List<Item> itemList = new ArrayList<>();
        // 최근에 등록된 5개 상품만 담을 리스트

        for(int i=0; i<5; i++) {
            itemList.add(list.get(i));
        }
        return itemList;
    }
}
