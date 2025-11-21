package com.pplip.domain.member.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class MemberResponse {
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class DupCheck{
        private boolean isDup;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class EmailCheck {
        private boolean isSuccess;
        private String message;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class ModifyNickName {
        private String nickname;
    }
}
