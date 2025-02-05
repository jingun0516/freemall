package com.estsoft.freemall.service;

import com.estsoft.freemall.dto.request.ProductOptionValuesRequest;
import com.estsoft.freemall.entity.ProductOptionValues;

public interface ProductOptionValuesService {
    ProductOptionValues addProductOptionValues(ProductOptionValuesRequest request);
}
