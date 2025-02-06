package com.estsoft.freemall.controller.api;

import com.estsoft.freemall.dto.request.PaymentMethodsRequest;
import com.estsoft.freemall.entity.PaymentMethods;
import com.estsoft.freemall.service.PaymentMethodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/payment-method")
public class PaymentMethodsApiController {
    private final PaymentMethodsService paymentMethodsService;

    @PostMapping
    public ResponseEntity<PaymentMethods> addPaymentMethod(@RequestBody PaymentMethodsRequest request) {
        return ResponseEntity.ok(paymentMethodsService.addPaymentMethod(request));
    }
}
