package com.pplip.domain.trip.attraction.persistence.entity;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class tag {
    private Long id;
    private String name;

    private LocalDateTime createdAt;
}
