package com.pplip.domain.board.notice.usecase.impl;

import com.pplip.domain.auth.persistence.entity.Account;
import com.pplip.domain.board.notice.api.request.NoticeRequest;
import com.pplip.domain.board.notice.api.response.NoticeResponse;
import com.pplip.domain.board.notice.usecase.NoticeService;
import com.pplip.global.exception.BoardLogicException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest(properties = {
        "spring.datasource.url=jdbc:mysql://127.0.0.1:3306/ssafy_trip?serverTimezone=UTC&characterEncoding=UTF-8",
        "spring.datasource.username=root",
        "spring.datasource.password=0000", // <--- 여기 비밀번호 꼭 넣으세요
        "spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver"
})
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class NoticeServiceImplTest {

    @Autowired
    NoticeService noticeService;

    @Test
    public void saveTest() throws Exception {
        // given
        NoticeRequest.Post post = NoticeRequest.Post.builder()
                .title("test")
                .content("content test")
                .imageIds(List.of(1L, 2L))
                .build();

        // when
        NoticeResponse.Detail savedPost = noticeService.post(post, Account.builder()
                .id(1L)
                .userId(1L).build());
        // then

        assertThat(savedPost.getTitle()).isEqualTo(post.getTitle());
        assertThat(savedPost.getNoticeImages().size()).isEqualTo(2);
        assertThat(savedPost.getAuthorImage().getId()).isEqualTo(1);
    }

    @Test
    public void update() throws Exception {
        // given
        NoticeRequest.Post post = NoticeRequest.Post.builder()
                .title("test")
                .content("content test")
                .imageIds(List.of(1L, 2L))
                .build();

        NoticeResponse.Detail savedPost = noticeService.post(post, Account.builder()
                .id(1L)
                .userId(1L).build());

        assertThat(savedPost.getTitle()).isEqualTo(post.getTitle());
        assertThat(savedPost.getNoticeImages().size()).isEqualTo(2);
        assertThat(savedPost.getAuthorImage().getId()).isEqualTo(1);

        NoticeRequest.Update update = NoticeRequest.Update.builder()
                .imageIds(List.of(3L, 4L))
                .build();
        Long id = savedPost.getId();
        // when
        NoticeResponse.Update updated = noticeService.update(update, id);
        // then
        assertThat(updated.getNoticeImages().size()).isEqualTo(4);
    }

    @Test
    public void delete() throws Exception {
        // given
        NoticeRequest.Post post = NoticeRequest.Post.builder()
                .title("test")
                .content("content test")
                .imageIds(List.of(1L, 2L))
                .build();

        NoticeResponse.Detail savedPost = noticeService.post(post, Account.builder()
                .id(1L)
                .userId(1L).build());
        Long id = savedPost.getId();
        // when
        noticeService.remove(id);
        // then
        assertThatThrownBy(() -> noticeService.findById(id))
                .isInstanceOf(BoardLogicException.class); // 예상되는 예외 클래스
//                .hasMessage("게시글을 찾을 수 없습니다."); // (선택) 예외 메시지까지 검증하고 싶을 때
    }
}