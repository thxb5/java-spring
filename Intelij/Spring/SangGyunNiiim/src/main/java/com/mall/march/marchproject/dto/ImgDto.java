package com.mall.march.marchproject.dto;

import com.mall.march.marchproject.entity.Img;
import com.mall.march.marchproject.entity.Item;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
public class ImgDto {
    private String img_id;
    private String img_name;
    private String modified_imgname;
    private Item item;

//    public ImgDto(String img_name, String modified_imgname, Item item) {
//        //this.product_id = product_id;
//        this.img_name = img_name;
//        this.modified_imgname = modified_imgname;
//        this.item = item;
//    }

    public Img toEntity() {
        return Img.builder()
                .imgName(img_name)
                .modImgname(modified_imgname)
                .item(item)
                .build();
    }

    public static ImgDto fromEntity(Img img) {
        return ImgDto.builder()
                .img_name(img.getImgName())
                .modified_imgname(img.getModImgname())
                .item(img.getItem())
                .build();
    }

}

