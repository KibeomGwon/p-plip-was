package com.pplip.member.persistence.entity;

import java.util.Arrays;

public enum Role {
    USER, ADMIN;

    public static Role getRole(String roleName) {
        return Arrays.stream(Role.values())
                .filter(role -> role.name().equals(roleName))
                .findFirst().orElseGet(null);
    }
}
