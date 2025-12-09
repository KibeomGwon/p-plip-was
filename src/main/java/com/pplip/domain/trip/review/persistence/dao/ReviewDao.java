package com.pplip.domain.trip.review.persistence.dao;

import com.pplip.domain.trip.review.api.response.ReviewResponse;
import com.pplip.domain.trip.review.persistence.entity.Review;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 리뷰 데이터에 접근하는 DAO 인터페이스
 */
@Mapper
public interface ReviewDao {
    int insert(Review review);

    List<ReviewResponse.Detail> findAllByAttractionNo(Long attractionNo);

    int update(Review review);

    int delete(Long id);
}
