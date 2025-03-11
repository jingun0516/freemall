package com.estsoft.freemall.controller.api;

import com.estsoft.freemall.dto.request.PaymentMethodProvidersRequest;
import com.estsoft.freemall.dto.request.PaymentMethodsRequest;
import com.estsoft.freemall.entity.PaymentMethodProviders;
import com.estsoft.freemall.entity.PaymentMethods;
import com.estsoft.freemall.entity.UserPaymentMethods;
import com.estsoft.freemall.service.PaymentMethodProvidersService;
import com.estsoft.freemall.service.PaymentMethodsService;
import com.estsoft.freemall.service.UserPaymentMethodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/payment-method")
public class PaymentMethodsApiController {
    private final PaymentMethodsService paymentMethodsService;
    private final PaymentMethodProvidersService paymentMethodProvidersService;
    private final UserPaymentMethodsService userPaymentMethodsService;

    @PostMapping
    public ResponseEntity<PaymentMethods> addPaymentMethod(@RequestBody PaymentMethodsRequest request) {
        return ResponseEntity.ok(paymentMethodsService.addPaymentMethod(request));
    }

    @PostMapping("/{paymentMethodId}/provider")
    public ResponseEntity<PaymentMethodProviders> addPaymentMethodProvider(@PathVariable Long paymentMethodId, @RequestBody PaymentMethodProvidersRequest request) {
        return ResponseEntity.ok(paymentMethodProvidersService.addPaymentMethodProvider(paymentMethodId, request));
    }

    @PostMapping("/{userId}/{paymentMethodId}")
    public ResponseEntity<UserPaymentMethods> saveUserPaymentMethods(@PathVariable Long userId, @PathVariable Long paymentMethodId) {
        return ResponseEntity.ok(
                userPaymentMethodsService.saveUserPaymentMethods(userId, paymentMethodId));
    }
}
