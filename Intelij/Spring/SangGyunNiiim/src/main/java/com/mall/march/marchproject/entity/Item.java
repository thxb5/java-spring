package com.mall.march.marchproject.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private int categoryId;
    private String productName;
    private int productPrice;
    @Column(length = 2048)
    private String productDetail;
    private int productAmount;
    private Timestamp upTime = new Timestamp(System.currentTimeMillis());
    private Timestamp modTime;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private List<Img> images = new ArrayList<>();

//    @JoinTable(name = "product_id", joinColumns = @JoinColumn(name="cho"))
//    public void addimage(Img img) {
//        images.add(img);
//    }


    public List<Img> getImages() {
        return images;
    }

}
