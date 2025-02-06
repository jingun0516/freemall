package com.estsoft.freemall.service.impl;

import com.estsoft.freemall.dto.request.ProductOptionValuesRequest;
import com.estsoft.freemall.entity.ProductOptionValues;
import com.estsoft.freemall.entity.ProductOptions;
import com.estsoft.freemall.repository.ProductOptionValuesRepository;
import com.estsoft.freemall.service.ProductOptionValuesService;
import com.estsoft.freemall.service.ProductOptionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductOptionValuesServiceImpl implements ProductOptionValuesService {
    private final ProductOptionValuesRepository productOptionValuesRepository;
    private final ProductOptionsService productOptionsService;

    @Override
    public ProductOptionValues addProductOptionValues(ProductOptionValuesRequest request) {
        ProductOptionValues productOptionValues = request.toEntity();
        ProductOptions productOptions = productOptionsService.getProductOptionsById(request.getProductOptionId());
        if(productOptions == null) {
            return null;
        }
        productOptionValues.setProductOption(productOptions);
        productOptions.getValues().add(productOptionValues);

        return productOptionValuesRepository.save(productOptionValues);
    }
}
