package com.estsoft.freemall.dto.request;

import com.estsoft.freemall.entity.PaymentMethods;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentMethodsRequest {
    private String method;

    public PaymentMethods toEntity() {
        return new PaymentMethods(method);
    }

}
