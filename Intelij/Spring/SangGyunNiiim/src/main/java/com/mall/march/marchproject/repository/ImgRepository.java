package com.mall.march.marchproject.repository;

import com.mall.march.marchproject.dto.ImgDto;
import com.mall.march.marchproject.entity.Img;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImgRepository extends JpaRepository<Img,Long> {
    List<Img> findDistinctByItem_ProductId(Long productId);

}
