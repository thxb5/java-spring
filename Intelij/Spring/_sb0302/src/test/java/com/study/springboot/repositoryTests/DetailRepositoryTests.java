package com.study.springboot.repositoryTests;

import com.study.springboot.entity.Dept;
import com.study.springboot.entity.Detail;
import com.study.springboot.repository.DeptRepository;
import com.study.springboot.repository.DetailRepository;
import groovy.util.logging.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Log4j2
public class DetailRepositoryTests {
    @Autowired
    DetailRepository detailRepository;

//    @Autowired(required=true)
//    public DeptRepository deptRepository;



    @Test
    public void selectTest() {
        List<Detail> lst = detailRepository.seleDtail();
        lst.forEach(t->{
            System.out.println(t);
        });
    }

    @Test
    @Transactional
    public void insertTest() {

        //deptRepository.insert(50, "연습", "연습부");
//        List<Dept> list = deptRepository.seleDept();
//        System.out.println(list);
    }
}
