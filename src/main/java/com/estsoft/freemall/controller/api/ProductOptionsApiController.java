package com.estsoft.freemall.controller.api;

import com.estsoft.freemall.dto.request.ProductOptionValuesRequest;
import com.estsoft.freemall.dto.request.ProductOptionsRequest;
import com.estsoft.freemall.entity.ProductOptionValues;
import com.estsoft.freemall.entity.ProductOptions;
import com.estsoft.freemall.service.ProductOptionValuesService;
import com.estsoft.freemall.service.ProductOptionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products/options")
public class ProductOptionsApiController {
    private final ProductOptionsService productOptionsService;
    private final ProductOptionValuesService productOptionValuesService;

    @PostMapping
    public ResponseEntity<ProductOptions> addProductOptions(@RequestBody ProductOptionsRequest request) {
        return ResponseEntity.ok(productOptionsService.addProductOption(request));
    }

    @GetMapping("/{productOptionId}")
    public ResponseEntity<ProductOptions> getProductOptions(@PathVariable Long productOptionId) {
        return ResponseEntity.ok(productOptionsService.getProductOptionById(productOptionId));
    }

    @PutMapping("/{productOptionId}")
    public ResponseEntity<ProductOptions> updateProductOptions(@PathVariable Long productOptionId,
                                                               @RequestBody ProductOptionsRequest request) {
        return ResponseEntity.ok(productOptionsService.updateProductOption(productOptionId, request));
    }

    @DeleteMapping("/{productOptionId}")
    public ResponseEntity<Void> deleteProductOptions(@PathVariable Long productOptionId) {
        boolean isDeleted = productOptionsService.deleteProductOption(productOptionId);

        if (!isDeleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{productOptionId}/values")
    public ResponseEntity<ProductOptionValues> addProductOptionValues(@PathVariable Long productOptionId, @RequestBody ProductOptionValuesRequest request) {
        return ResponseEntity.ok(productOptionValuesService.addProductOptionValue(productOptionId, request));
    }
}
