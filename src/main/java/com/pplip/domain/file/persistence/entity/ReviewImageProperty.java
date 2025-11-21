package com.pplip.domain.file.persistence.entity;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewImageProperty extends FileProperty {
    private Long reviewId;

    @Override
    public ImageType supports() {
        return ImageType.REVIEW;
    }
}
