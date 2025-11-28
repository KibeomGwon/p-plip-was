package com.pplip.domain.trip.attraction.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public class AttractionResponse {

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Region {
        private Sido sido;
        private List<Gugun> guguns;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Sido {
        private Integer sidoCode;
        private String sidoName;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Gugun {
        private Integer gugunCode;
        private String gugunName;
    }
}
