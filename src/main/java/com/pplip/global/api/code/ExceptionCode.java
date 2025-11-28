package com.pplip.global.api.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionCode {
    NOT_FOUND(1), NOT_SUPPORT(2);
    private int value;

}
