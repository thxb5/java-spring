package com.study.spring0307.repository;

import com.study.spring0307.entity.Person;
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
        IntStream.rangeClosed(1, 10).forEach(t ->{
            Person person = Person.builder().name("홍"+t).addr("마포"+t).build();
            em.persist(person);
        });

        return "입력";
    }

    @Transactional
    public String update() {
//        Person person = em.find(Person.class, 1L);
//        person.setAddr("성남");
        /* manage 영속성 부분에 find로 select한 다음에 set을 해주면 자동으로 flush DB해준다,, */
        /* 영속성으로 값을 가져오와서 수정,삭제 등을 해주는 개념,, */

        Person person = Person.builder().id(2L).name("가나다").addr("수원").build();
        em.merge(person);
        return "수정";
    }

    public List<Person> selectAll() {
        String sql = "select p from Person p"; /* p는 별칭 */
        return em.createQuery(sql, Person.class).getResultList();
    }

    @Transactional
    public String delete() {
//        Person person = em.find(Person.class, 1L);
        /* 1번 자료 유무를 모르는 경우는 find를 해서 영속성을 얻고 하는게 낫지만 아니면 아래 방식이 낫다,, */

        Person person = Person.builder().id(1L).build();
        person = em.merge(person);
        /* merge를 먼저 해줘서 영속성을 얻는다,, */
        System.out.println("em.contains(person) = " + em.contains(person));
        em.remove(person);
        return "삭제";
    }

}
