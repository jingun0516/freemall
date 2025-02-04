package com.estsoft.freemall.service;

import com.estsoft.freemall.dto.request.ProductsRequest;
import com.estsoft.freemall.entity.Products;

public interface ProductsService {
    Products addProduct(ProductsRequest request);
}
