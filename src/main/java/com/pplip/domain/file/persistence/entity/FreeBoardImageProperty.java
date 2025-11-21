package com.pplip.domain.file.persistence.entity;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FreeBoardImageProperty extends FileProperty {

    private Long boardId;

    @Override
    public ImageType supports() {
        return ImageType.FREE_BOARD;
    }
}
