package com.estsoft.freemall.service;

import com.estsoft.freemall.dto.request.PaymentMethodsRequest;
import com.estsoft.freemall.entity.PaymentMethods;

public interface PaymentMethodsService {
    PaymentMethods addPaymentMethod(PaymentMethodsRequest request);
    PaymentMethods getPaymentMethodById(Long id);
}
