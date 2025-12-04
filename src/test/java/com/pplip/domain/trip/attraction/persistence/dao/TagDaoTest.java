package com.pplip.domain.trip.attraction.persistence.dao;

import com.pplip.domain.trip.attraction.persistence.entity.Tag;
import com.pplip.global.page.PageRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TagDaoTest {

    @Autowired
    TagDao dao;

    @Test
    @DisplayName("성공: 모든 태그 조회 (페이지네이션)")
    void findAll_Success() {
        // when
        List<Tag> all = assertDoesNotThrow(() -> dao.findAll(new PageRequest(1, 20)));
        // then
        assertNotNull(all);
    }

    @Test
    @DisplayName("성공: 특정 명소의 태그 조회")
    void findByNo_Success() {
        // when
        List<Tag> allByAttractionNo = assertDoesNotThrow(() -> dao.findAllByAttractionNo(1L));
        // then
        assertNotNull(allByAttractionNo);
    }

    @Test
    @DisplayName("엣지 케이스: 존재하지 않는 명소의 태그 조회")
    void findByNo_Fail_WhenNotFound() {
        // when
        List<Tag> allByAttractionNo = assertDoesNotThrow(() -> dao.findAllByAttractionNo(9999L));
        // then
        assertNotNull(allByAttractionNo);
        assertThat(allByAttractionNo).isEmpty();
    }
}