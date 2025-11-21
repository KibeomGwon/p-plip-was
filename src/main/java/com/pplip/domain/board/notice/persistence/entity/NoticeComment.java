package com.pplip.domain.board.notice.persistence.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoticeComment {
    private Long id;
    private Long NoticeboardId;
    private Long authorId;

    private String content;
    private boolean isRemoved;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
