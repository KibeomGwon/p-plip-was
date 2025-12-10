package com.pplip.domain.trip.review.usecase.impl;

import com.pplip.domain.auth.persistence.entity.Account;
import com.pplip.domain.trip.review.api.request.ReviewRequest;
import com.pplip.domain.trip.review.api.response.ReviewResponse;
import com.pplip.domain.trip.review.usecase.ReviewService;
import com.pplip.global.page.Page;
import com.pplip.global.page.PageRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ReviewServiceImplTest {

    @Autowired
    ReviewService reviewService;

    @Test
    public void 찾기테스트() throws Exception {
        // given
        // when
        Page<ReviewResponse.Detail> page = reviewService.findAll(56644L, new PageRequest(0, 20));
        int totalCount = page.getTotalCount();
        // then
        Assertions.assertThat(totalCount).isEqualTo(0);
        Assertions.assertThat(page.getList().isEmpty()).isTrue();
    }

    @Test
    public void 작성테스트() throws Exception {
        // given
        ReviewRequest.Post post = ReviewRequest.Post.builder()
                .content("테스트")
                .build();

        Account account = Account.builder().userId(1L).build();

        // when
        ReviewResponse.Detail detail = reviewService.post(post, 56644L, account);
        // then
        Assertions.assertThat(detail.getAuthorId()).isEqualTo(1L);
        Assertions.assertThat(detail.getContent()).isEqualTo("테스트");
        Assertions.assertThat(detail.isAuthor()).isTrue();
    }

    @Test
    public void update() throws Exception {
        // given
        ReviewRequest.Post post = ReviewRequest.Post.builder()
                .content("테스트")
                .build();

        Account account = Account.builder().userId(1L).build();

        // when
        ReviewResponse.Detail detail = reviewService.post(post, 56644L, account);
        System.out.println(detail);

        ReviewRequest.Update update = ReviewRequest.Update.builder()
                .content("수정된 텍스트")
                .build();

        // when
        ReviewResponse.Update updated = reviewService.update(update, detail.getId(), account);
        // then
        Assertions.assertThat(updated.getContent()).isEqualTo("수정된 텍스트");
        System.out.println(updated);
    }

    @Test
    public void delete() throws Exception {
        // given
        ReviewRequest.Post post = ReviewRequest.Post.builder()
                .content("테스트")
                .build();

        Account account = Account.builder().userId(1L).build();

        ReviewResponse.Detail detail = reviewService.post(post, 56644L, account);
        System.out.println(detail);

        // when
        long delete = reviewService.delete(detail.getId(), account);

        // then
        Assertions.assertThat(delete).isEqualTo(detail.getId());
        Assertions.assertThat(reviewService.findAll(56644L, new PageRequest(0, 20)).getList().size()).isEqualTo(0);
    }
}