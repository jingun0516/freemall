package com.estsoft.freemall.service.impl;

import com.estsoft.freemall.dto.request.PaymentMethodProvidersRequest;
import com.estsoft.freemall.entity.PaymentMethodProviders;
import com.estsoft.freemall.entity.PaymentMethods;
import com.estsoft.freemall.repository.PaymentMethodProvidersRepository;
import com.estsoft.freemall.service.PaymentMethodProvidersService;
import com.estsoft.freemall.service.PaymentMethodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentMethodProviderServicesImpl implements PaymentMethodProvidersService {
    private final PaymentMethodProvidersRepository paymentMethodProvidersRepository;
    private final PaymentMethodsService paymentMethodsService;

    @Override
    public PaymentMethodProviders addPaymentMethodProvider(PaymentMethodProvidersRequest request) {
        PaymentMethodProviders paymentMethodProviders = request.toEntity();
        PaymentMethods paymentMethod = paymentMethodsService.getPaymentMethodById(request.getPaymentMethodId());
        if(paymentMethod == null) {
            return null;
        }
        paymentMethodProviders.setPaymentMethod(paymentMethod);

        return paymentMethodProvidersRepository.save(paymentMethodProviders);
    }
}
