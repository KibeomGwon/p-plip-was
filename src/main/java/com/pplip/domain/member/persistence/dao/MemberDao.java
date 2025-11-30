package com.pplip.domain.member.persistence.dao;

import com.pplip.domain.member.persistence.entity.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MemberDao {
    Optional<Member> findById(Long id);

    int update(Member member);

    int insert(Member member);

    int delete(Long id);
}
