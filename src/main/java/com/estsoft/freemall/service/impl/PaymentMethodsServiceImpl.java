package com.estsoft.freemall.service.impl;

import com.estsoft.freemall.dto.request.PaymentMethodsRequest;
import com.estsoft.freemall.entity.PaymentMethods;
import com.estsoft.freemall.repository.PaymentMethodsRepository;
import com.estsoft.freemall.service.PaymentMethodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentMethodsServiceImpl implements PaymentMethodsService {
    private final PaymentMethodsRepository paymentMethodsRepository;

    @Override
    public PaymentMethods addPaymentMethod(PaymentMethodsRequest request) {
        return paymentMethodsRepository.save(request.toEntity());
    }

    @Override
    public PaymentMethods getPaymentMethodById(Long id) {
        return paymentMethodsRepository.findById(id).orElse(null);
    }
}
