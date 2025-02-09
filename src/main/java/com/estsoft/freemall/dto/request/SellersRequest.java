package com.estsoft.freemall.dto.request;

import com.estsoft.freemall.entity.Sellers;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SellersRequest {
    private String storeName;
    private String storeDescription;

    public Sellers toEntity() {
        return new Sellers(storeName, storeDescription);
    }

    public Sellers updateEntity(Sellers seller) {
        if(!storeName.isEmpty()) {
            seller.setStoreName(storeName);
        }

        if(!storeDescription.isEmpty()) {
            seller.setStoreDescription(storeDescription);
        }

        return seller;
    }

}
