package com.estsoft.freemall.service;

import com.estsoft.freemall.dto.request.ReviewsRequest;
import com.estsoft.freemall.entity.Reviews;

public interface ReviewsService {
    Reviews addReview(Long userId, Long productId, ReviewsRequest request);
}
