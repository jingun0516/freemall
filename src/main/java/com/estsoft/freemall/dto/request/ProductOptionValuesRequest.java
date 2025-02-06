package com.estsoft.freemall.dto.request;

import com.estsoft.freemall.entity.ProductOptionValues;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductOptionValuesRequest {
    private Long productOptionId;
    private String value;

    public ProductOptionValues toEntity() {
        return new ProductOptionValues(value);
    }
}
