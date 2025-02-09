package com.estsoft.freemall.service.impl;

import com.estsoft.freemall.dto.request.ReviewsRequest;
import com.estsoft.freemall.entity.Products;
import com.estsoft.freemall.entity.Reviews;
import com.estsoft.freemall.entity.Users;
import com.estsoft.freemall.repository.ReviewsRepository;
import com.estsoft.freemall.service.ProductsService;
import com.estsoft.freemall.service.ReviewsService;
import com.estsoft.freemall.service.UsersService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewsServiceImpl implements ReviewsService {
    private final ReviewsRepository reviewsRepository;
    private final UsersService usersService;
    private final ProductsService productsService;

    @Override
    public Reviews addReview(Long userId, Long productId, ReviewsRequest request) {
        Users user = usersService.getUserById(userId);
        Products product = productsService.getProductById(productId);

        if(user == null || product == null) {
            throw new EntityNotFoundException("user or product not found");
        }

        Reviews review = request.toEntity();
        review.setUser(user);
        review.setProduct(product);

        return reviewsRepository.save(review);
    }
}
