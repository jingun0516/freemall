package com.estsoft.freemall.dto.request;

import com.estsoft.freemall.entity.OrderItems;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemsRequest {
    private Long productId;
    private Integer quantity;

    public OrderItems toEntity() {
        return new OrderItems(quantity);
    }
}
