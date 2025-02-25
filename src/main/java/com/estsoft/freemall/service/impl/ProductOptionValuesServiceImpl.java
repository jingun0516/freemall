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
    public ProductOptionValues addProductOptionValue(Long productOptionId, ProductOptionValuesRequest request) {
        ProductOptionValues productOptionValues = request.toEntity();
        ProductOptions productOptions = productOptionsService.getProductOptionById(productOptionId);
        if(productOptions == null) {
            return null;
        }
        productOptionValues.setProductOption(productOptions);
        productOptions.getValues().add(productOptionValues);

        return productOptionValuesRepository.save(productOptionValues);
    }

    @Override
    public ProductOptionValues getProductOptionValue(Long productOptionValueId) {
        return productOptionValuesRepository.findById(productOptionValueId).orElse(null);
    }

    @Override
    public ProductOptionValues updateProductOptionValue(Long productOptionValueId, ProductOptionValuesRequest request) {
        ProductOptionValues productOptionValues = getProductOptionValue(productOptionValueId);
        productOptionValues.setValue(request.getValue());
        return productOptionValuesRepository.save(productOptionValues);
    }

    @Override
    public ProductOptionValues deleteProductOptionValue(Long productOptionId) {
        return null;
    }


}
