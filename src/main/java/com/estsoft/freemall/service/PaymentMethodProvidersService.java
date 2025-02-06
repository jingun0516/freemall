package com.estsoft.freemall.service;

import com.estsoft.freemall.dto.request.PaymentMethodProvidersRequest;
import com.estsoft.freemall.entity.PaymentMethodProviders;

public interface PaymentMethodProvidersService {
    PaymentMethodProviders addPaymentMethodProvider(PaymentMethodProvidersRequest request);
}
