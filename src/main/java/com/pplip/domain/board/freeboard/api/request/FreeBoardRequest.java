package com.pplip.domain.board.freeboard.api.request;

import com.pplip.domain.file.api.request.FileRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public class FreeBoardRequest {
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class BoardPost{
        private String title;
        private String content;
        private List<Long> ids;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class BoardUpdate {
        private String title;
        private String content;
        private List<FileRequest> images;
    }
}
