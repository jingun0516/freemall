package com.estsoft.freemall.controller.api;

import com.estsoft.freemall.dto.request.DiscountsRequest;
import com.estsoft.freemall.dto.request.ProductsRequest;
import com.estsoft.freemall.entity.Discounts;
import com.estsoft.freemall.entity.Products;
import com.estsoft.freemall.service.DiscountsService;
import com.estsoft.freemall.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductsApiController {
    private final ProductsService productsService;
    private final DiscountsService discountsService;

    @PostMapping
    public ResponseEntity<Products> addProduct(@RequestBody ProductsRequest request) {
        return ResponseEntity.ok(productsService.addProduct(request.getSellerId(), request));
    }

    @PostMapping("/discounts")
    public ResponseEntity<Products> addDiscount(@RequestBody DiscountsRequest request) {
        Products product = productsService.getProductById(request.getProductId());
        if(product == null) {
            return ResponseEntity.notFound().build();
        }
        Discounts discount = discountsService.addDiscount(request.getProductId(), request);
        product.getDiscounts().add(discount);
        return ResponseEntity.ok(product);
    }
}
