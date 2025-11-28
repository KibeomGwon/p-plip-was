package com.pplip.global.api.code;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
public enum ErrorCode {
    USER_NOT_FOUND_ERROR(DomainCode.USER, ExceptionCode.NOT_FOUND, "USER_NOT_FOUND_ERROR"),
    FILE_TYPE_NOT_SUPPORT(DomainCode.FILE, ExceptionCode.NOT_SUPPORT, "FILE_TYPE_NOT_SUPPORT"),
    UN_EXPECTED_TOKEN_VALIDATION(DomainCode.AUTH, ExceptionCode.UN_EXPECTED, "UN_EXPECTED_TOKEN_VALIDATION"),
    TOKEN_EXPIRED(DomainCode.AUTH, ExceptionCode.EXPIRED, "토큰이 만료되었습니다."),
    TOKEN_MALFORMED(DomainCode.AUTH, ExceptionCode.MALFORMED, "토큰이 위조되었습니다"),
    TOKEN_INVALID_SIGNATURE(DomainCode.AUTH,  ExceptionCode.INVALID, "토큰 서명이 일치하지 않습니다"),
    TOKEN_EMPTY(DomainCode.AUTH, ExceptionCode.EMPTY, "토큰이 비어있습니다." );


    private DomainCode domainCode;
    private ExceptionCode exceptionCode;
    @Getter
    private String defaultMessage;

    public int status() {
        return domainCode.getValue() * 100 + exceptionCode.getValue();
    }


}
