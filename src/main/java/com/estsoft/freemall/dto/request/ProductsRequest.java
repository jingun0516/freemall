package com.estsoft.freemall.dto.request;

import com.estsoft.freemall.entity.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductsRequest {
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stockQuantity;
    private String categoryName;
    private String manufacturerName;

    public Products toEntity() {
        return Products.builder()
                .name(name)
                .description(description)
                .price(price)
                .stockQuantity(stockQuantity).build();
    }
}
