package com.study.springboot.repository;

import com.study.springboot.dto.MyDataMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MyDataMongoRepository
            extends MongoRepository<MyDataMongo, Long> {
    public List<MyDataMongo> findByName(String s);
    public List<MyDataMongo> findByNameLike(String s);
}
