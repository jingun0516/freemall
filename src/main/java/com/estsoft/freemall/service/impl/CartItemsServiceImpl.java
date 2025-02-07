package com.estsoft.freemall.service.impl;

import com.estsoft.freemall.dto.request.CartItemsRequest;
import com.estsoft.freemall.entity.Cart;
import com.estsoft.freemall.entity.CartItems;
import com.estsoft.freemall.entity.Products;
import com.estsoft.freemall.repository.CartItemsRepository;
import com.estsoft.freemall.service.CartItemsService;
import com.estsoft.freemall.service.CartService;
import com.estsoft.freemall.service.ProductsService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartItemsServiceImpl implements CartItemsService {
    private final CartItemsRepository cartItemsRepository;
    private final CartService cartService;
    private final ProductsService productsService;

    @Override
    public CartItems addCartItem(Long userId, CartItemsRequest request) {
        Cart cart = cartService.getCartByUserId(userId);
        Products product = productsService.getProductById(request.getProductId());
        if(cart == null || product == null) {
            throw new EntityNotFoundException("cart or product not found");
        }
        CartItems cartItem = request.toEntity();
        cartItem.setCart(cart);
        cartItem.setProduct(product);

        return cartItemsRepository.save(cartItem);
    }
}
