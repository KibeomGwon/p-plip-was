package com.pplip.domain.member.persistence.dao;

import com.pplip.domain.member.persistence.entity.Profile;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface ProfileDao {
    int insert(Profile profile);

    Optional<Profile> findById(Long id);

    boolean existsNickname(String nickname);

    int update(Profile profile);

    int delete(Long id);
}
