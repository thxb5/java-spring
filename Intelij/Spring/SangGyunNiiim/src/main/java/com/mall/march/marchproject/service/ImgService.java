package com.mall.march.marchproject.service;

import com.mall.march.marchproject.dto.ImgDto;
import com.mall.march.marchproject.dto.ItemDto;
import com.mall.march.marchproject.dto.UserDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ImgService {

    List<ImgDto> selectAllImgs();
    List<ImgDto> selectImgsDistinct();
    List<ImgDto> selectImgsByProductId(Long product_Id);
}
