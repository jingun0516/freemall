package com.estsoft.freemall.dto.request;

import com.estsoft.freemall.entity.ProductOptionValues;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductOptionValuesRequest {
    private String value;

    public ProductOptionValues toEntity() {
        return new ProductOptionValues(value);
    }

    public void updateEntity(ProductOptionValues productOptionValue) {
        productOptionValue.update(value);
    }
}
