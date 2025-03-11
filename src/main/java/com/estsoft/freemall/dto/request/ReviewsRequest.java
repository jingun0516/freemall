package com.estsoft.freemall.dto.request;

import com.estsoft.freemall.entity.Reviews;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewsRequest {
    private Long productId;
    private Integer rating;
    private String content;

    public Reviews toEntity() {
        return new Reviews(rating, content);
    }
}
