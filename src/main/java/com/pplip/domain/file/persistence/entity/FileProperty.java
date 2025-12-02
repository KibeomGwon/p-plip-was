package com.pplip.domain.file.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class FileProperty {
    private Long id;
    private String originFileName;
    private String path;
    private String savedFileName;
    private long size;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
