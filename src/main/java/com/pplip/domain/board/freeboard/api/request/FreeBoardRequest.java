package com.pplip.domain.board.freeboard.api.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class FreeBoardRequest {
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class BoardPost{
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
}
