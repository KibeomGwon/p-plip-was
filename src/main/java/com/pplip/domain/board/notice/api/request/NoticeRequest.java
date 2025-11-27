package com.pplip.domain.board.notice.api.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class NoticeRequest {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class BoardPost {
        private String title;
        private String content;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class BoardUpdate {
        private String title;
        private String content;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class CommentPost {
        private String content;
    }
}