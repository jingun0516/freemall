package com.estsoft.freemall.controller.api;

import com.estsoft.freemall.dto.request.CartItemsRequest;
import com.estsoft.freemall.entity.CartItems;
import com.estsoft.freemall.service.CartItemsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cart")
public class CartApiController {
    private final CartItemsService cartItemsService;

    @PostMapping
    public ResponseEntity<CartItems> addCartItem(@RequestBody CartItemsRequest request) {
        // TODO: 후에 로그인한 유저의 ID로 변경
        return ResponseEntity.ok(cartItemsService.addCartItem(8L, request));
    }
}
