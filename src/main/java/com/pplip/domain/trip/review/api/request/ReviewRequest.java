package com.pplip.domain.trip.review.api.request;

import com.pplip.domain.file.api.request.FileRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public class ReviewRequest {
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Post {
        private String content;
        private List<Long> fileIds;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Update {
        private String content;
        private List<FileRequest> files;
    }
}
