package com.estsoft.freemall.service;

import com.estsoft.freemall.dto.request.SellersRequest;
import com.estsoft.freemall.entity.Sellers;

public interface SellersService {
    Sellers registerSeller(Long userId, SellersRequest request);
}
