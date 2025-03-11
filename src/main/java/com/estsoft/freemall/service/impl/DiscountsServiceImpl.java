package com.estsoft.freemall.service.impl;

import com.estsoft.freemall.dto.request.DiscountsRequest;
import com.estsoft.freemall.entity.Discounts;
import com.estsoft.freemall.entity.Products;
import com.estsoft.freemall.repository.DiscountsRepository;
import com.estsoft.freemall.service.DiscountsService;
import com.estsoft.freemall.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Discounts> getDiscounts(Long productId) {
        List<Discounts> discounts = discountsRepository.findByProductId(productId);
        List<Discounts> results = new ArrayList<>();

        for(Discounts discount : discounts) {
            LocalDateTime startDate = discount.getStartDate();
            LocalDateTime endDate = discount.getEndDate();
            if(LocalDateTime.now().isAfter(startDate) && LocalDateTime.now().isBefore(endDate)) {
                results.add(discount);
            }
        }

        return results;
    }

    @Override
    public BigDecimal calculateDiscountedPrice(BigDecimal price, List<Discounts> discounts) {
        BigDecimal maxDiscountRate = BigDecimal.ZERO;
        BigDecimal maxDiscountAmount = BigDecimal.ZERO;

        for(Discounts discount : discounts) {
            if(discount.getDiscountRate().compareTo(maxDiscountRate) > 0) {
                maxDiscountRate = discount.getDiscountRate();
            }
            if(discount.getDiscountPrice().compareTo(maxDiscountAmount) > 0) {
                maxDiscountAmount = discount.getDiscountPrice();
            }
        }

        BigDecimal priceAfterRate = price.subtract(maxDiscountAmount);
        BigDecimal priceAfterAmount = price.subtract(price.multiply(maxDiscountRate));
        if(priceAfterAmount.compareTo(priceAfterRate) > 0) {
            return priceAfterAmount;
        }

        return priceAfterRate;
    }
}
