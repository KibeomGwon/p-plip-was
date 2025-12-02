package com.pplip.domain.file.persistence.entity;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoticeBoardImageProperty extends FileProperty {
    private Long boardId;
}
