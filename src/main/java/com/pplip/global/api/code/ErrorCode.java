package com.pplip.global.api.code;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ErrorCode {
    USER_NOT_FOUND_ERROR(DomainCode.USER, ExceptionCode.NOT_FOUND, "USER_NOT_FOUND_ERROR");

    private DomainCode domainCode;
    private ExceptionCode exceptionCode;
    private String defaultMessage;

    public int status() {
        return domainCode.getValue() * 100 + exceptionCode.getValue();
    }


}
