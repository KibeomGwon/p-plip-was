package com.pplip.global.api.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DomainCode {
    USER(1),
    BOARD(2),
    ATTRACTION(3),
    PLAN(4),
    FILE(5);
    private int value;
}
