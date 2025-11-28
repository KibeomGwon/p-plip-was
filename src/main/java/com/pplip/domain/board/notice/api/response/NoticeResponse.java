package com.pplip.domain.board.notice.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class NoticeResponse {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Summary {
        private Long id;
        private String title;
        private String authorName;
        private int viewCnt;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Detail {
        private Long id;
        private String title;
        private String authorName;
        private String content;
        private int viewCnt;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Update {
        private Long id;
        private String title;
        private String authorName;
        private String content;
        private int viewCnt;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
    }
}
