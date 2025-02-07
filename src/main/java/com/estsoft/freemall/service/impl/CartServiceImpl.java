package com.estsoft.freemall.service.impl;

import com.estsoft.freemall.entity.Cart;
import com.estsoft.freemall.entity.Users;
import com.estsoft.freemall.repository.CartRepository;
import com.estsoft.freemall.service.CartService;
import com.estsoft.freemall.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final UsersService usersService;

    @Override
    public Cart addCart(Long userId) {
        Users user = usersService.getUserById(userId);
        if(user == null) {
            return null;
        }
        Cart cart = new Cart();
        cart.setUser(user);

        return cartRepository.save(cart);
    }

    @Override
    public Cart getCartByUserId(Long userId) {
        return cartRepository.getByUserId(userId);
    }
}
