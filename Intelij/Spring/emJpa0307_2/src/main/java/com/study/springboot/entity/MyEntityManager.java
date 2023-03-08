package com.study.springboot.entity;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.IntStream;

@Repository
@Log4j2
public class MyEntityManager {
    @PersistenceContext
    EntityManager em;
    @Transactional
    public String create() {
        IntStream.rangeClosed(1, 10).forEach(t->{
            Person person = Person.builder().name("홍"+t)
                    .addr("마포"+t).build();
            em.persist(person);
        });

        return "입력";
    }

    @Transactional
    public String update() {
//        Person person = em.find(Person.class, 1L);
//        person.setAddr("성남");
        Person person = Person.builder().id(2L).name("가나다")
                .addr("수원").build();
        em.merge(person);
        return "수정";
    }

    public List<Person> selectAll() {
        String sql = "select p from Person p";
        List<Person> list = em.createQuery(sql, Person.class).getResultList();
        return  list;
    }

    @Transactional
    public String delete() {
//        Person person = em.find(Person.class, 1L);
        Person person = Person.builder().id(1L).build();
        person = em.merge(person);
        System.out.println("######"+em.contains(person));
        em.remove(person);
        return "삭제";
    }
}
