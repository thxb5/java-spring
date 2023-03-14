package com.mall.march.marchproject.controller;

import com.mall.march.marchproject.dto.ItemDto;
import com.mall.march.marchproject.repository.ImgEntityManager;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Log4j2
@Controller
public class ImgController {

    private final ImgEntityManager em;

    public ImgController(ImgEntityManager em) {
        this.em = em;
    }

    @PostMapping("/uploadImg")
    public String uploadImgs(ItemDto itemDto, MultipartFile[] imgFile) throws IOException {
        em.insertImgs(itemDto, imgFile);
        return "/mypage/admin/regitem";
    }

}
