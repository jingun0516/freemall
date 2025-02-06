package com.estsoft.freemall.dto.request;

import com.estsoft.freemall.entity.ProductOptions;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductOptionsRequest {
    private String attribute;

    public ProductOptions toEntity() {
        return new ProductOptions(attribute);
    }
}
