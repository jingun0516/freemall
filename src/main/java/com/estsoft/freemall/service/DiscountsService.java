package com.estsoft.freemall.service;

import com.estsoft.freemall.dto.request.DiscountsRequest;
import com.estsoft.freemall.entity.Discounts;

public interface DiscountsService {
    Discounts addDiscount(Long productId, DiscountsRequest request);
}
