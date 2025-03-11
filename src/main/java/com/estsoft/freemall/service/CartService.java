package com.estsoft.freemall.service;

import com.estsoft.freemall.entity.Cart;

public interface CartService {
    Cart addCart(Long userId);
    Cart getCartByUserId(Long userId);
}
