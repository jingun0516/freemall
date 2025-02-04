package com.estsoft.freemall.controller.api;

import com.estsoft.freemall.dto.request.ProductsRequest;
import com.estsoft.freemall.entity.Products;
import com.estsoft.freemall.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductsApiController {
    private final ProductsService productsService;

    @PostMapping
    public ResponseEntity<Products> addProduct(@RequestBody ProductsRequest request) {
        return ResponseEntity.ok(productsService.addProduct(request));
    }
}
