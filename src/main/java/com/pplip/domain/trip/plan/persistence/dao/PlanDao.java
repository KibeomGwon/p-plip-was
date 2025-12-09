package com.pplip.domain.trip.plan.persistence.dao;

import com.pplip.domain.trip.plan.api.response.PlanResponse;
import com.pplip.domain.trip.plan.persistence.entity.Plan;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

/**
 * 여행 계획 데이터에 접근하는 DAO 인터페이스
 */
@Mapper
public interface PlanDao {
    List<PlanResponse.Summary> findAll(Long userId);

    Optional<PlanResponse.Detail> findById(Long id);

    int insert(Plan plan);

    int update(Plan plan);

    int delete(Long id);
}
