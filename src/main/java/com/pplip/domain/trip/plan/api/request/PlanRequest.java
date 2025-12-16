package com.pplip.domain.trip.plan.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PlanRequest {
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Post {
        private String title;

        private LocalDate startDate;
        private LocalDate endDate;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Update {
        private String title;

        private LocalDate startDate;
        private LocalDate endDate;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class SuggestPlan {
        @JsonProperty("attraction_id")
        private String attractionId;
        @JsonProperty("user_theme")
        private String query;
    }
}
