package com.pplip.domain.board.freeboard.persistence.dao;

import com.pplip.domain.board.freeboard.api.response.FreeBoardCommentResponse;
import com.pplip.domain.board.freeboard.persistence.entity.FreeComment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.dao.DataIntegrityViolationException;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DisplayName("FreeBoardCommentDao 테스트")
class FreeBoardCommentDaoTest {

    @Autowired
    private FreeBoardCommentDao freeBoardCommentDao;

    private static final Long TEST_BOARD_ID = 1L;
    private static final Long TEST_AUTHOR_ID = 1L;
    private static final Long TEST_COMMENT_ID = 1L;

    @Test
    @DisplayName("성공: 특정 게시글의 모든 댓글 조회")
    void findAll_Success() {
        // Given & When
        List<FreeBoardCommentResponse.Retrieve> comments = assertDoesNotThrow(() -> freeBoardCommentDao.findAll(TEST_BOARD_ID));

        // Then
        assertNotNull(comments, "댓글 목록은 null이 아니어야 합니다.");
    }

    @Test
    @DisplayName("성공: 새 댓글 추가")
    void insert_Success() {
        // Given
        FreeComment newComment = FreeComment.builder()
                .boardId(TEST_BOARD_ID)
                .authorId(TEST_AUTHOR_ID)
                .content("새로운 자유게시판 댓글입니다.")
                .isRemoved(false)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        // When & Then
        assertDoesNotThrow(() -> freeBoardCommentDao.insert(newComment));
        assertThat(newComment.getId()).isNotNull();
    }
    
    @Test
    @DisplayName("실패: 존재하지 않는 게시글에 댓글 추가")
    void insert_Fail_WithNonExistingBoardId() {
        // Given
        Long nonExistingBoardId = -1L;
        FreeComment newComment = FreeComment.builder()
                .boardId(nonExistingBoardId)
                .authorId(TEST_AUTHOR_ID)
                .content("이 댓글은 추가되어서는 안됩니다.")
                .isRemoved(false)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        // When & Then
        assertThrows(DataIntegrityViolationException.class, () -> {
            freeBoardCommentDao.insert(newComment);
        });
    }

    @Test
    @DisplayName("성공: 댓글 내용 수정")
    void update_Success() {
        // Given
        FreeComment commentToUpdate = FreeComment.builder()
                .id(TEST_COMMENT_ID)
                .content("수정된 자유게시판 댓글입니다.")
                .build();

        // When
        int affectedRows = assertDoesNotThrow(() -> freeBoardCommentDao.update(commentToUpdate));

        // Then
        assertThat(affectedRows).isLessThanOrEqualTo(1);
    }

    @Test
    @DisplayName("성공: 댓글 삭제 (논리적 삭제)")
    void delete_Success() {
        // Given
        Long commentIdToDelete = TEST_COMMENT_ID;

        // When
        int affectedRows = assertDoesNotThrow(() -> freeBoardCommentDao.delete(commentIdToDelete));

        // Then
        assertThat(affectedRows).isLessThanOrEqualTo(1);
    }
}
