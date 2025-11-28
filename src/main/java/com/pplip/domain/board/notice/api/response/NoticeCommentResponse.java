package com.pplip.domain.board.notice.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class NoticeCommentResponse {
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class List {
        private String authorName;
        private String content;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
    }

}
