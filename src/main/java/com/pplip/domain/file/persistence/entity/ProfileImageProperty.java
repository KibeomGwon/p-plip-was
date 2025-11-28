package com.pplip.domain.file.persistence.entity;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileImageProperty extends FileProperty {

    private Long profileId;

}
