package com.estsoft.freemall.service.impl;

import com.estsoft.freemall.dto.request.OrderHistoryRequest;
import com.estsoft.freemall.entity.OrderHistory;
import com.estsoft.freemall.entity.UserPaymentMethods;
import com.estsoft.freemall.entity.Users;
import com.estsoft.freemall.repository.OrderHistoryRepository;
import com.estsoft.freemall.service.OrderHistoryService;
import com.estsoft.freemall.service.UserPaymentMethodsService;
import com.estsoft.freemall.service.UsersService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderHistoryServiceImpl implements OrderHistoryService {
    private final OrderHistoryRepository orderHistoryRepository;
    private final UsersService usersService;
    private final UserPaymentMethodsService userPaymentMethodsService;

    @Override
    public OrderHistory addOrderHistory(Long userId, OrderHistoryRequest request) {
        // TODO: userId 로그인한 회원으로 변경
        OrderHistory orderHistory = request.toEntity();
        Users user = usersService.getUserById(userId);
        UserPaymentMethods userPaymentMethod = userPaymentMethodsService.getUserPaymentMethodsByUserId(userId);
        if (user == null || userPaymentMethod == null) {
            throw new EntityNotFoundException("user not found");
        }
        orderHistory.setUser(user);
        orderHistory.setUserPaymentMethod(userPaymentMethod);

        return orderHistoryRepository.save(orderHistory);
    }

    @Override
    public OrderHistory getOrderHistoryById(Long orderId) {
        return orderHistoryRepository.findById(orderId).orElse(null);
    }

    @Override
    public OrderHistory updateOrderHistory(Long orderId, OrderHistoryRequest request) {
        OrderHistory orderHistory = getOrderHistoryById(orderId);
        orderHistory = request.updateEntity(orderHistory);
        UserPaymentMethods userPaymentMethod = userPaymentMethodsService.getUserPaymentMethodsByUserId(request.getUserPaymentMethodId());
        if (userPaymentMethod == null) {
            throw new EntityNotFoundException("userPaymentMethod not found");
        }
        orderHistory.setUserPaymentMethod(userPaymentMethod);

        return orderHistoryRepository.save(orderHistory);
    }

    @Override
    public void deleteOrderHistoryById(Long orderId) {
        orderHistoryRepository.deleteById(orderId);
    }
}
