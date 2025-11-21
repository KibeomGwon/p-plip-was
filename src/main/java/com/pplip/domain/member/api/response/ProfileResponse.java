package com.pplip.domain.member.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

public class ProfileResponse {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class ModifyNickName {
        private String nickname;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ImageUrl {
        private String url;
    }
}
