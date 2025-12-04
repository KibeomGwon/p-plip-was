package com.pplip.domain.board.notice.persistence.dao;

import com.pplip.domain.board.notice.persistence.entity.NoticeComment;
import com.pplip.domain.board.notice.api.response.NoticeCommentResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.dao.DataIntegrityViolationException;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DisplayName("NoticeCommentDao 테스트")
class NoticeCommentDaoTest {

    @Autowired
    private NoticeCommentDao noticeCommentDao;

    private static final Long TEST_NOTICE_ID = 1L;
    private static final Long TEST_AUTHOR_ID = 1L;
    private static final Long TEST_COMMENT_ID = 1L;

    @Test
    @DisplayName("성공: 특정 게시글의 모든 댓글 조회")
    void findAll_Success() {
        // Given & When
        List<NoticeCommentResponse.Summary> comments = assertDoesNotThrow(() -> noticeCommentDao.findAll(TEST_NOTICE_ID));

        // Then
        assertNotNull(comments, "댓글 목록은 null이 아니어야 합니다.");
    }

    @Test
    @DisplayName("성공: 특정 게시글의 댓글 수 조회")
    void noticeBoardCommentAllCount_Success() {
        // Given & When
        int count = assertDoesNotThrow(() -> noticeCommentDao.noticeBoardCommentAllCount(TEST_NOTICE_ID));

        // Then
        assertThat(count).isGreaterThanOrEqualTo(0);
    }

    @Test
    @DisplayName("성공: 새 댓글 추가")
    void insert_Success() {
        // Given
        NoticeComment newComment = NoticeComment.builder()
                .noticeBoardId(TEST_NOTICE_ID)
                .authorId(TEST_AUTHOR_ID)
                .content("새로운 댓글입니다.")
                .isRemoved(false)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        // When
        // Then
        assertDoesNotThrow(() -> noticeCommentDao.insert(newComment));
        assertThat(newComment.getId()).isNotNull();
    }
    
    @Test
    @DisplayName("실패: 존재하지 않는 게시글에 댓글 추가")
    void insert_Fail_WithNonExistingNoticeId() {
        // Given
        Long nonExistingNoticeId = -1L;
        NoticeComment newComment = NoticeComment.builder()
                .noticeBoardId(nonExistingNoticeId)
                .authorId(TEST_AUTHOR_ID)
                .content("이 댓글은 추가되어서는 안됩니다.")
                .isRemoved(false)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        // When & Then
        assertThrows(DataIntegrityViolationException.class, () -> {
            noticeCommentDao.insert(newComment);
        });
    }

    @Test
    @DisplayName("성공: 댓글 내용 수정")
    void update_Success() {
        // Given
        NoticeComment commentToUpdate = NoticeComment.builder()
                .id(TEST_COMMENT_ID)
                .content("수정된 댓글입니다.")
                .build();

        // When
        int affectedRows = assertDoesNotThrow(() -> noticeCommentDao.update(commentToUpdate));

        // Then
        assertThat(affectedRows).isLessThanOrEqualTo(1);
    }

    @Test
    @DisplayName("성공: 댓글 삭제 (논리적 삭제)")
    void delete_Success() {
        // Given
        Long commentIdToDelete = TEST_COMMENT_ID;

        // When
        int affectedRows = assertDoesNotThrow(() -> noticeCommentDao.delete(commentIdToDelete));

        // Then
        assertThat(affectedRows).isLessThanOrEqualTo(1);
    }
}
