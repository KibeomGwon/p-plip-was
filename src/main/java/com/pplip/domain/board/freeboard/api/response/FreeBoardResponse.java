package com.pplip.domain.board.freeboard.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

public class FreeBoardResponse {
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BoardList{
        private String title;
        private String authorName;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private int likeCnt;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Detail {
        private String title;
        private String authorName;
        private String content;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private int likeCnt;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Update {
        private String title;
        private String content;
        private String authorName;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private int likeCnt;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Remove {
        private long id;
        private String title;
    }
}
