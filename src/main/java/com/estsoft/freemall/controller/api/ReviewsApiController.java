package com.estsoft.freemall.controller.api;

import com.estsoft.freemall.dto.request.ReviewsRequest;
import com.estsoft.freemall.entity.Reviews;
import com.estsoft.freemall.service.ReviewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/review")
public class ReviewsApiController {
    private final ReviewsService reviewsService;

    @PostMapping
    public ResponseEntity<Reviews> addReview(@RequestBody ReviewsRequest request) {
        return ResponseEntity.ok(reviewsService.addReview(8L, request.getProductId(), request));
    }
}
