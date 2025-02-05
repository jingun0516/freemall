package com.estsoft.freemall.service.impl;

import com.estsoft.freemall.dto.request.ProductOptionsRequest;
import com.estsoft.freemall.entity.ProductOptions;
import com.estsoft.freemall.entity.Products;
import com.estsoft.freemall.repository.ProductOptionsRepository;
import com.estsoft.freemall.service.ProductOptionsService;
import com.estsoft.freemall.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductOptionsServiceImpl implements ProductOptionsService {
    private final ProductOptionsRepository productOptionsRepository;
    private final ProductsService productsService;

    @Override
    public ProductOptions addProductOptions(ProductOptionsRequest request) {
        ProductOptions productOptions = request.toEntity();
        Products product = productsService.getProductById(request.getProductId());
        if(product == null) {
            return null;
        }
        productOptions.setProduct(product);

        return productOptionsRepository.save(productOptions);
    }
}
