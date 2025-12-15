package com.pplip.domain.trip.plan.api.request;

import com.pplip.domain.file.persistence.entity.ModifyStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ToDoRequest {
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class PostTodo {
        private Long planId;
        private Long attractionId;

        private String description;
        private LocalDate willStartAt;
        private LocalDate willEndAt;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Update {
        private Long id;
        private Long planId;
        private Long attractionId;
        private String title;

        private String description;
        private LocalDateTime willStartAt;
        private LocalDateTime willEndAt;
    }
}
