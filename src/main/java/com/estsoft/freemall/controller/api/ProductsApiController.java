package com.estsoft.freemall.controller.api;

import com.estsoft.freemall.dto.request.DiscountsRequest;
import com.estsoft.freemall.dto.request.ProductsRequest;
import com.estsoft.freemall.entity.Discounts;
import com.estsoft.freemall.entity.ProductOptionMapping;
import com.estsoft.freemall.entity.Products;
import com.estsoft.freemall.service.DiscountsService;
import com.estsoft.freemall.service.ProductOptionMappingService;
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
    private final ProductOptionMappingService productOptionMappingService;

    @PostMapping
    public ResponseEntity<Products> addProduct(@RequestBody ProductsRequest request) {
        return ResponseEntity.ok(productsService.addProduct(request.getSellerId(), request));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Products> getProduct(@PathVariable Long productId) {
        return ResponseEntity.ok(productsService.getProductById(productId));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable Long productId) {
        return ResponseEntity.ok(productsService.deleteProduct(productId));
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Products> updateProduct(@PathVariable Long productId, @RequestBody ProductsRequest request) {
        return ResponseEntity.ok(productsService.updateProduct(productId, request));
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

    @PostMapping("/{productId}/options/{optionId}")
    public ResponseEntity<ProductOptionMapping> addOptionToProduct(@PathVariable Long productId, @PathVariable Long optionId) {
        return ResponseEntity.ok(productOptionMappingService.saveProductOptionMapping(productId, optionId));
    }
}
