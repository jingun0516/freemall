package com.estsoft.freemall.service;

import com.estsoft.freemall.dto.request.ProductOptionsRequest;
import com.estsoft.freemall.entity.ProductOptions;

public interface ProductOptionsService {
    ProductOptions addProductOption(ProductOptionsRequest request);
    ProductOptions getProductOptionById(Long id);
}
