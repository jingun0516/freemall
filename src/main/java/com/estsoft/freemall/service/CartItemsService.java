package com.estsoft.freemall.service;

import com.estsoft.freemall.dto.request.CartItemsRequest;
import com.estsoft.freemall.entity.CartItems;

public interface CartItemsService {
    CartItems addCartItem(Long userId, CartItemsRequest request);
}
