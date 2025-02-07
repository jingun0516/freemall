package com.estsoft.freemall.dto.request;

import com.estsoft.freemall.entity.CartItems;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItemsRequest {
    private Long productId;
    private Integer quantity;

    public CartItems toEntity() {
        return new CartItems(quantity);
    }
}
