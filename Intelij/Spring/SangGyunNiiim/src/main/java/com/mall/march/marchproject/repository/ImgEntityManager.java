package com.mall.march.marchproject.repository;

import com.mall.march.marchproject.dto.ImgDto;
import com.mall.march.marchproject.dto.ItemDto;
import com.mall.march.marchproject.entity.Item;
import lombok.Data;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

@Repository
@Log4j2
public class ImgEntityManager {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public String insertImgs(ItemDto itemDto, MultipartFile[] imgFile) throws IOException {
        Item itemEntity = itemDto.toEntity();
        em.persist(itemEntity);
        // DTO로 받은 Item 엔티티화 시켜서 영속성 주입
        Long productId = itemEntity.getProductId();
        //String path = "D:/";
        // 윈도우에서
        // String path = "/Users/oresama/Documents/itemImgs";
        // 맥에서
        log.info("----> 아이템 아이디? " + itemEntity.getProductId());
        log.info("----> 아이템 등록?" + em.contains(itemEntity));

        // List<ImgDto> imgList = new ArrayList<>();

        for (MultipartFile imgs : imgFile) {
            String originalFileName = imgs.getOriginalFilename();
            // 기존 파일 이름
            int result1 = originalFileName.lastIndexOf(".");
            int length = originalFileName.length();
            String extension = originalFileName.substring(result1,length);
            // 기존 파일 확장자

            String newFileName = productId + "_" + System.nanoTime() + extension;
            // 저장할 새로운 파일 이름

            if (!imgs.isEmpty()) {
                //ImgDto img = new ImgDto(originalFileName, newFileName, itemEntity);
                ImgDto img = ImgDto.builder().img_name(originalFileName).modified_imgname(newFileName).item(itemEntity).build();
                em.persist(img.toEntity());
                // 이미지 db에 img엔티티 저장
                File modifiedFileName = new File(newFileName);
                imgs.transferTo(modifiedFileName);
                // 이미지 지정된 경로에 저장
                // imgList.add(img);
            }
        }
        return "성공";

    }
}
