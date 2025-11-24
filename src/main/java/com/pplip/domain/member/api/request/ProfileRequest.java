package com.pplip.domain.member.api.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

public class ProfileRequest {
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Nickname {
        private String nickname;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Image {
        private MultipartFile image;
    }
}
