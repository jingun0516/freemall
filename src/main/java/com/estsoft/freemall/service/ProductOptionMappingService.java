package com.estsoft.freemall.service;

import com.estsoft.freemall.entity.ProductOptionMapping;

public interface ProductOptionMappingService {
    ProductOptionMapping saveProductOptionMapping(Long productId, Long optionId);
}
