package com.estsoft.freemall.service.impl;

import com.estsoft.freemall.dto.request.ProductsRequest;
import com.estsoft.freemall.entity.Categories;
import com.estsoft.freemall.entity.Manufacturers;
import com.estsoft.freemall.entity.Products;
import com.estsoft.freemall.entity.Sellers;
import com.estsoft.freemall.repository.ProductsRepository;
import com.estsoft.freemall.service.CategoriesService;
import com.estsoft.freemall.service.ManufacturersService;
import com.estsoft.freemall.service.ProductsService;
import com.estsoft.freemall.service.SellersService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductsServiceImpl implements ProductsService {
    private final ProductsRepository productsRepository;
    private final CategoriesService categoriesService;
    private final ManufacturersService manufacturersService;
    private final SellersService sellersService;


    @Override
    public Products addProduct(Long sellerId, ProductsRequest request) {
        Products product = request.toEntity();
        Categories category = categoriesService.getCategoryByName(request.getCategoryName());
        Manufacturers manufacturers = manufacturersService.getManufacturerByName(request.getManufacturerName());
        Sellers seller = sellersService.getSellerById(sellerId);
        if(category == null || manufacturers == null || seller == null) {
            throw new EntityNotFoundException("category or manufacturers or seller not found");
        }
        product.setCategory(category);
        product.setManufacturer(manufacturers);
        product.setSeller(seller);
        return productsRepository.save(product);
    }

    @Override
    public Products getProductById(Long productId) {
        return productsRepository.findById(productId).orElse(null);
    }

    @Override
    public Products updateProduct(Long productId, ProductsRequest request) {
        Products product = getProductById(productId);
        product = request.updateEntity(product);

        Categories category = categoriesService.getCategoryByName(request.getCategoryName());
        Manufacturers manufacturers = manufacturersService.getManufacturerByName(request.getManufacturerName());
        if(category == null || manufacturers == null) {
            throw new EntityNotFoundException("category or manufacturers not found");
        }
        product.setCategory(category);
        product.setManufacturer(manufacturers);

        return productsRepository.save(product);
    }

    @Override
    public Boolean deleteProduct(Long id) {
        Products product = getProductById(id);
        if(product == null) {
            return false;
        }
        productsRepository.delete(product);
        return true;
    }
}
