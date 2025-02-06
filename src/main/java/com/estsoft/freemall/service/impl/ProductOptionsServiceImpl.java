package com.estsoft.freemall.service.impl;

import com.estsoft.freemall.dto.request.ProductOptionsRequest;
import com.estsoft.freemall.entity.ProductOptions;
import com.estsoft.freemall.entity.Products;
import com.estsoft.freemall.repository.ProductOptionsRepository;
import com.estsoft.freemall.service.ProductOptionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductOptionsServiceImpl implements ProductOptionsService {
    private final ProductOptionsRepository productOptionsRepository;

    @Override
    public ProductOptions addProductOptions(ProductOptionsRequest request) {
        return productOptionsRepository.save(request.toEntity());
    }

    @Override
    public ProductOptions getProductOptionsById(Long id) {
        return productOptionsRepository.findById(id).orElse(null);
    }
}
