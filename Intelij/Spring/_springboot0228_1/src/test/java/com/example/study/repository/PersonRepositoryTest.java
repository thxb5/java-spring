package com.example.study.repository;

import com.example.study.entity.Person;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonRepositoryTest {
    @Autowired
    PersonRepository personRepository;

    @Test
    public void testIns() {
        IntStream.rangeClosed(1,10).forEach(t->{
            Person person = Person.builder().name("이름"+t).addr("주소"+t).build();
            System.out.println(person);
            personRepository.save(person);
        });
    }

    @Test //한건식 셀렉트
    public void testSel() {
        Person person = personRepository.findById(13L).orElseThrow();
        //Person person = personRepository.getOne(12L);
        System.out.println(person);
        List<Person> list = personRepository.findAll();
        list.stream().forEach(i->{
            System.out.println(i);
        });
    }

    @Test //업데이트
    public void testUpd() {
        Person person = Person.builder().pid(12L).name("김갑돌").addr("마포구").build();
        personRepository.save(person);
    }

    @Test //삭제
    public void testDel() {
        personRepository.deleteById(12L);
    }

    @Test //JPQL 셀렉트 방식
    public void testSel3() {
        //List<Person> person = personRepository.findPersonByName("이름1");
        //List<Person> person = personRepository.findPersonByNameLike("%1%");
        List<Person> person = personRepository.findPersonByNameLikeOrderByPidDesc("%1%");
        person.stream().forEach(t->{
            System.out.println(t);
        });
    }

    @Test //쿼리문 사용 전체 선택
    public void testSel4() {
        List<Person> list = personRepository.selectAll();
        list.stream().forEach(r->{
            System.out.println(r);
        });
    }

    @Test //쿼리문 사용 선택
    public void testSel5() {
        List<Person> list = personRepository.selectName("%름%");
        list.stream().forEach(e->{
            System.out.println(e);
        });
    }

    @Test //insert
    @Disabled
    public void insert1() {
        personRepository.insertPerson("보르미","연습구");
    }

    @Test
    public void insert2() {
        Person person = Person.builder().name("홍길순").addr("송파구").build();
        personRepository.insertPerson2(person);
    }








}