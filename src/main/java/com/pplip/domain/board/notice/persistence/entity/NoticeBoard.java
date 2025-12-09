package com.pplip.domain.board.notice.persistence.entity;

import com.pplip.domain.board.notice.api.request.NoticeRequest;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoticeBoard {
    private Long id;
    private Long authorId;

    private String title;
    private String content;
    private Integer viewCnt;
    private Boolean isRemoved;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
