package com.estsoft.freemall.controller.api;

import com.estsoft.freemall.dto.request.ProductOptionValuesRequest;
import com.estsoft.freemall.dto.request.ProductOptionsRequest;
import com.estsoft.freemall.entity.ProductOptionValues;
import com.estsoft.freemall.entity.ProductOptions;
import com.estsoft.freemall.service.ProductOptionValuesService;
import com.estsoft.freemall.service.ProductOptionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/values")
    public ResponseEntity<ProductOptionValues> addProductOptionValues(@RequestBody ProductOptionValuesRequest request) {
        return ResponseEntity.ok(productOptionValuesService.addProductOptionValue(request));
    }
}
