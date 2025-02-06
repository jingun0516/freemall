package com.estsoft.freemall.dto.request;

import com.estsoft.freemall.entity.PaymentMethodProviders;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentMethodProvidersRequest {
    private Long paymentMethodId;
    private String provider;

    public PaymentMethodProviders toEntity() {
        return new PaymentMethodProviders(provider);
    }
}
