package com.estsoft.freemall.service;

import com.estsoft.freemall.dto.request.DiscountsRequest;
import com.estsoft.freemall.entity.Discounts;

import java.math.BigDecimal;
import java.util.List;

public interface DiscountsService {
    Discounts addDiscount(Long productId, DiscountsRequest request);
    List<Discounts> getDiscounts(Long productId);
    BigDecimal calculateDiscountedPrice(BigDecimal price, List<Discounts> discounts);
}
