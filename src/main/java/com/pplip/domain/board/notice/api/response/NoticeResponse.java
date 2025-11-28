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
    public static class BoardList {
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
    public static class BoardUpdate {
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
    public static class BoardRemove {
        private String id;
        private String title;
    }
}
