package com.example.study.repository;

import com.example.study.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findPersonByName(String name);
    List<Person> findPersonByNameLike(String name);

    //역순 정렬
    List<Person> findPersonByNameLikeOrderByPidDesc(String name);

    @Query(value = "select * from person", nativeQuery = true)
    List<Person> selectAll();

    @Query(value = "select * from person where name like %:name", nativeQuery = true)
    List<Person> selectName(@Param("name") String name);

    @Modifying
    @Transactional
    @Query(value = "insert into person(name, addr) values (:name, :addr)", nativeQuery = true)
    void insertPerson(@Param("name") String name, @Param("addr") String addr);

    @Modifying
    @Transactional
    @Query(value = "insert into person(name, addr) values (:#{#person.name}, :#{#person.addr})", nativeQuery = true)
    void insertPerson2(@Param("person") Person person);

}
