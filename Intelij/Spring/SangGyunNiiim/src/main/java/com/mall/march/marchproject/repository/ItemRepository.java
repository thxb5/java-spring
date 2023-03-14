package com.mall.march.marchproject.repository;

import com.mall.march.marchproject.dto.ItemDto;
import com.mall.march.marchproject.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {

    @Query(value = "select * from item order by up_Time desc", nativeQuery = true)
    List<Item> selectAllItems();

    Item findItemByProductId(Long productId);
}
