package com.estsoft.freemall.service;

import com.estsoft.freemall.entity.UserPaymentMethods;

public interface UserPaymentMethodsService {
    UserPaymentMethods saveUserPaymentMethods(Long userId, Long paymentMethodId);
    UserPaymentMethods getUserPaymentMethodsByUserId(Long userId);
}
