package com.pplip.member.persistence.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {
    private Long id;
    private String email;
    private String password;
    private Role role;
    private LocalDateTime passwordUpdatedAt;
    private LocalDateTime createdAt;
}
