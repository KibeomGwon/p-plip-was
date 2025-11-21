package com.pplip.domain.board.freeboard.persistence.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FreeComment {
    private Long id;
    private Long boardId;
    private Long authorId;

    private String content;
    private boolean isRemoved;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
