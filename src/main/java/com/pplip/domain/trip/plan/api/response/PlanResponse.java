package com.pplip.domain.trip.plan.api.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PlanResponse {
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Summary {
        private Long id;
        private String title;

        private LocalDate startDate;
        private LocalDate endDate;

        private LocalDateTime createdAt;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Detail {
        private Long id;
        private String title;
        @JsonIgnore
        private Long userId;
        private LocalDate startDate;
        private LocalDate endDate;

        private LocalDateTime createdAt;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Update {
        private Long id;
        private String title;

        private LocalDate startDate;
        private LocalDate endDate;

        private LocalDateTime updatedAt;
    }
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Remove{
        private Long id;
        private String title;
    }
}
