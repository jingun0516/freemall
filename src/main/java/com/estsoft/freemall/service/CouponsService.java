package com.estsoft.freemall.service;

import com.estsoft.freemall.dto.request.CouponsRequest;
import com.estsoft.freemall.entity.Coupons;

public interface CouponsService {
    Coupons addCoupons(CouponsRequest request);
}
