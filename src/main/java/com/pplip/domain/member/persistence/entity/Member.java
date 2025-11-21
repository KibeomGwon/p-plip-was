package com.pplip.domain.member.persistence.entity;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {
    private Long id;
    private Long profileId;

    private String name;
    private LocalDate birth;
}