package com.estsoft.freemall.service.impl;

import com.estsoft.freemall.entity.ProductOptionMapping;
import com.estsoft.freemall.entity.ProductOptions;
import com.estsoft.freemall.entity.Products;
import com.estsoft.freemall.repository.ProductOptionMappingRepository;
import com.estsoft.freemall.service.ProductOptionMappingService;
import com.estsoft.freemall.service.ProductOptionsService;
import com.estsoft.freemall.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductOptionMappingServiceImpl implements ProductOptionMappingService {
    private final ProductOptionMappingRepository productOptionMappingRepository;
    private final ProductsService productsService;
    private final ProductOptionsService productOptionsService;

    @Override
    public ProductOptionMapping saveProductOptionMapping(Long productId, Long optionId) {
        Products product = productsService.getProductById(productId);
        ProductOptions productOption = productOptionsService.getProductOptionById(optionId);

        if(product == null || productOption == null){
            return null;
        }
        ProductOptionMapping productOptionMapping = new ProductOptionMapping(product, productOption);

        product.getOptionMappings().add(productOptionMapping);
        productOption.getOptionMappings().add(productOptionMapping);

        return productOptionMappingRepository.save(productOptionMapping);
    }
}
