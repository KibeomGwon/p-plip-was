package com.pplip.domain.file.persistence.dao;

import com.pplip.domain.file.persistence.entity.ProfileImageProperty;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProfileImagePropertyDao {
    int insert(ProfileImageProperty property);

    int delete(Long id);
}
