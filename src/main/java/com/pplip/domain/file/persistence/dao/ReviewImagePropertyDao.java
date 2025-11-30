package com.pplip.domain.file.persistence.dao;

import com.pplip.domain.file.persistence.entity.ReviewImageProperty;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewImagePropertyDao {
    int insert(ReviewImageProperty property);

    int delete(Long id);

    int bulkUpdateReviewId(List<Long> imageIds, Long reviewId);
}
