package com.pplip.domain.trip.review.persistence.dao;

import com.pplip.domain.trip.review.api.response.ReviewResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReviewDaoTest {

    @Autowired
    ReviewDao dao;

    @Test
    @DisplayName("find all by no")
    void findAllByNo() {
        // when
        List<ReviewResponse.Detail> allByAttractionNo = dao.findAllByAttractionNo(1L);
        // then
        Assertions.assertThat(allByAttractionNo.size()).isEqualTo(0);
    }

}