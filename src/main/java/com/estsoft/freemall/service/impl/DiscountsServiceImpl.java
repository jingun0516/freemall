package com.estsoft.freemall.service.impl;

import com.estsoft.freemall.dto.request.DiscountsRequest;
import com.estsoft.freemall.entity.Discounts;
import com.estsoft.freemall.entity.Products;
import com.estsoft.freemall.repository.DiscountsRepository;
import com.estsoft.freemall.service.DiscountsService;
import com.estsoft.freemall.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiscountsServiceImpl implements DiscountsService {
    private final DiscountsRepository discountsRepository;
    private final ProductsService productsService;

    @Override
    public Discounts addDiscount(Long productId, DiscountsRequest request) {
        Discounts discount = request.toEntity();
        Products product = productsService.getProductById(productId);
        if(product == null) {
            return null;
        }
        discount.setProduct(product);

        return discountsRepository.save(discount);
    }
}
