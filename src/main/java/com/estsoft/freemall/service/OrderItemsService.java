package com.estsoft.freemall.service;

import com.estsoft.freemall.dto.request.OrderItemsRequest;
import com.estsoft.freemall.entity.OrderItems;

public interface OrderItemsService {
    OrderItems addOrderItem(Long orderHistoryId, OrderItemsRequest request);
    OrderItems getOrderItem(Long orderItemId);
}
