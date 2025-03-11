package com.estsoft.freemall.service;

import com.estsoft.freemall.dto.request.OrderHistoryRequest;
import com.estsoft.freemall.entity.OrderHistory;

public interface OrderHistoryService {
    OrderHistory addOrderHistory(Long userId, OrderHistoryRequest request);

    OrderHistory getOrderHistoryById(Long orderId);

    OrderHistory updateOrderHistory(Long orderId, OrderHistoryRequest request);

    void deleteOrderHistoryById(Long orderId);
}