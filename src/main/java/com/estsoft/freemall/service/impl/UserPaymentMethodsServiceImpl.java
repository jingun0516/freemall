package com.estsoft.freemall.service.impl;

import com.estsoft.freemall.entity.PaymentMethods;
import com.estsoft.freemall.entity.UserPaymentMethods;
import com.estsoft.freemall.entity.Users;
import com.estsoft.freemall.repository.UserPaymentMethodsRepository;
import com.estsoft.freemall.service.PaymentMethodsService;
import com.estsoft.freemall.service.UserPaymentMethodsService;
import com.estsoft.freemall.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserPaymentMethodsServiceImpl implements UserPaymentMethodsService {
    private final UserPaymentMethodsRepository userPaymentMethodsRepository;
    private final UsersService usersService;
    private final PaymentMethodsService paymentMethodsService;

    @Override
    public UserPaymentMethods saveUserPaymentMethods(Long userId, Long paymentMethodId) {
        Users user = usersService.getUserById(userId);
        PaymentMethods paymentMethod = paymentMethodsService.getPaymentMethodById(paymentMethodId);
        if(user == null || paymentMethod == null) {
            return null;
        }

        return userPaymentMethodsRepository.save(new UserPaymentMethods(user, paymentMethod));
    }

    @Override
    public UserPaymentMethods getUserPaymentMethodsByUserId(Long userId) {
        return userPaymentMethodsRepository.findByUserId(userId);
    }
}
