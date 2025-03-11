package com.estsoft.freemall.service.impl;

import com.estsoft.freemall.dto.request.CouponsRequest;
import com.estsoft.freemall.entity.Coupons;
import com.estsoft.freemall.repository.CouponsRepository;
import com.estsoft.freemall.service.CouponsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CouponsServiceOmpl implements CouponsService {
    private final CouponsRepository couponsRepository;

    @Override
    public Coupons addCoupons(CouponsRequest request) {
        return null;
    }
}
