package com.study.springboot.repository;

import com.study.springboot.entity.Notice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
class NoticeRepositoryTest {
    @Autowired
    NoticeRepository noticeRepository;
    @Test
    public void testIns() {
        Long seq = noticeRepository.selectMaxSeq();
        Notice notice = Notice.builder().seq(seq+10000L).title("제목").content("내용").build();
        noticeRepository.insertNotice(notice);
    }


}