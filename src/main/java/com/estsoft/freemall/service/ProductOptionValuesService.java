package com.estsoft.freemall.service;

import com.estsoft.freemall.dto.request.ProductOptionValuesRequest;
import com.estsoft.freemall.entity.ProductOptionValues;

public interface ProductOptionValuesService {
    ProductOptionValues addProductOptionValue(Long productOptionId, ProductOptionValuesRequest request);
    ProductOptionValues updateProductOptionValue(Long productOptionValueId, ProductOptionValuesRequest request);
    ProductOptionValues deleteProductOptionValue(Long productOptionValueId);
    ProductOptionValues getProductOptionValue(Long productOptionValueId);
}
