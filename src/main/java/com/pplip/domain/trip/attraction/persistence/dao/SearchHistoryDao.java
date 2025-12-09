package com.pplip.domain.trip.attraction.persistence.dao;

import com.pplip.domain.trip.attraction.persistence.entity.SearchHistory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 검색 기록 데이터에 접근하는 DAO 인터페이스
 */
@Mapper
public interface SearchHistoryDao {

    int insert(SearchHistory searchHistory);

    List<SearchHistory> findAll(Long userId);
}
