package com.mall.march.marchproject.service;

import com.mall.march.marchproject.dto.ImgDto;
import com.mall.march.marchproject.dto.ItemDto;
import com.mall.march.marchproject.entity.Img;
import com.mall.march.marchproject.repository.ImgRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImgServiceImpl implements ImgService {

    private final ImgRepository imgRepository;
    private final ItemService itemService;

    public ImgServiceImpl(ImgRepository imgRepository, ItemService itemService) {
        this.imgRepository = imgRepository;
        this.itemService = itemService;
    }

    @Override
    public List<ImgDto> selectAllImgs() {
        List<Img> entityList = imgRepository.findAll();
        // 모든 이미지 가져와서
        List<ImgDto> imgDtoList = new ArrayList<>();
        // Dto넣을 빈 배열

        for(Img img : entityList) {
            ImgDto imgDto = ImgDto.fromEntity(img);
            // 각 엔티티를 Dto로 변환
            imgDtoList.add(imgDto);
            // 변환된 Dto 리스트에 넣기
        }
        return imgDtoList;

    }

    @Override
    public List<ImgDto> selectImgsDistinct() {
        // 상품 번호당 사진 1장씩만 리스트에 저장하는 메소드

        List<ItemDto> entityList = itemService.selectAllItems();
        // 모든 상품 검색
        List<ImgDto> imgDtoListDistinct = new ArrayList<>();
        // 각 상품의 이미지 1장씩만 담을 리스트
        for(int i=0; i<entityList.size(); i++) {
            Long prdId = entityList.get(i).getProduct_id();
            // 상품의 리스트에서 상품번호 뽑아와서
            Img img = imgRepository.findDistinctByItem_ProductId(prdId).get(0);
            // 각 상품의 0번째 이미지만 가져와서
            ImgDto imgDto = ImgDto.fromEntity(img);
            // Dto로 변환시킨 뒤\
            imgDtoListDistinct.add(imgDto);
            // 빈 리스트에 Dto를 넣는다.
        }
        return imgDtoListDistinct;
    }

    @Override
    public List<ImgDto> selectImgsByProductId(Long product_Id) {

        List<Img> list = imgRepository.findDistinctByItem_ProductId(product_Id);
        List<ImgDto> imgDtoList = new ArrayList<>();

        for(Img img : list) {
            ImgDto imgDto = ImgDto.fromEntity(img);
            imgDtoList.add(imgDto);
        }

        return imgDtoList;
    }


}