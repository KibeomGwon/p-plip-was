package com.pplip.domain.trip.review.usecase;

import com.pplip.domain.trip.review.api.request.ReviewRequest;
import com.pplip.domain.trip.review.api.response.ReviewResponse;
import com.pplip.global.page.Page;
import com.pplip.global.page.PageRequest;
import org.springframework.security.core.userdetails.UserDetails;

public interface ReviewService {
    Page<ReviewResponse.Detail> findAll(Long attractionId, PageRequest pageRequest);

    ReviewResponse.Detail post(ReviewRequest.Post post, Long attractionId, UserDetails userDetails);

    ReviewResponse.Update update(ReviewRequest.Update update, Long id, UserDetails userDetails);

    long delete(Long id, UserDetails userDetails);
}
