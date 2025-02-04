package com.estsoft.freemall.service;

import com.estsoft.freemall.dto.request.ManufacturersRequest;
import com.estsoft.freemall.entity.Manufacturers;

public interface ManufacturersService {
    Manufacturers addManufacturer(ManufacturersRequest request);
    Manufacturers getManufacturerByName(String name);
}
