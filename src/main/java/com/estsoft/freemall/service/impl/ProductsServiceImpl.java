package com.estsoft.freemall.service.impl;

import com.estsoft.freemall.dto.request.ProductsRequest;
import com.estsoft.freemall.entity.Categories;
import com.estsoft.freemall.entity.Manufacturers;
import com.estsoft.freemall.entity.Products;
import com.estsoft.freemall.repository.ProductsRepository;
import com.estsoft.freemall.service.CategoriesService;
import com.estsoft.freemall.service.ManufacturersService;
import com.estsoft.freemall.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductsServiceImpl implements ProductsService {
    private final ProductsRepository productsRepository;
    private final CategoriesService categoriesService;
    private final ManufacturersService manufacturersService;


    @Override
    public Products addProduct(ProductsRequest request) {
        Products product = request.toEntity();
        Categories category = categoriesService.getCategoryByName(request.getCategoryName());
        Manufacturers manufacturers = manufacturersService.getManufacturerByName(request.getManufacturerName());
        if(category == null || manufacturers == null) {
            return null;
        }
        product.setCategory(category);
        product.setManufacturer(manufacturers);
        return productsRepository.save(product);
    }
}
