package com.pplip.global.exception.handler;

import com.pplip.global.api.response.CommonResponse;
import com.pplip.global.exception.CustomAuthenticationException;
import com.pplip.global.exception.BoardLogicException;
import com.pplip.global.exception.FileException;
import com.pplip.global.exception.UnvalidEmailCodeException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomAuthenticationException.class)
    public CommonResponse<Void> authenticationException(CustomAuthenticationException e) {
        return CommonResponse.fail(e.getErrorCode(), e.getMessage());
    }

    @ExceptionHandler(UnvalidEmailCodeException.class)
    public CommonResponse<Void> unvalidEmailCodeException(UnvalidEmailCodeException e) {
        return CommonResponse.fail(e.getErrorCode(), e.getMessage());
    }

    @ExceptionHandler(BoardLogicException.class)
    public CommonResponse<Void> failToCreateBoardException(BoardLogicException e) {
        return CommonResponse.fail(e.getErrorCode(), e.getMessage());
    }

    @ExceptionHandler(FileException.class)
    public CommonResponse<Void> fileException(FileException e) {
        return CommonResponse.fail(e.getErrorCode(), e.getMessage());
    }
}
