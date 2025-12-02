package com.pplip.domain.trip.attraction.persistence.dao;

import com.pplip.domain.trip.attraction.persistence.entity.Tag;
import com.pplip.global.page.PageRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TagDaoTest {

    @Autowired
    TagDao dao;

    @Test
    @DisplayName("findAll")
    void findAll() {
        // when
        List<Tag> all = dao.findAll(new PageRequest(1, 20));
        // then
        Assertions.assertThat(all.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("find by no")
    void findByNo() {
        // when
        List<Tag> allByAttractionNo = dao.findAllByAttractionNo(1L);
        // then
        Assertions.assertThat(allByAttractionNo.size()).isEqualTo(0);
    }
}