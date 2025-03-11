package com.estsoft.freemall.service;

import com.estsoft.freemall.dto.request.ManufacturersRequest;
import com.estsoft.freemall.entity.Manufacturers;

public interface ManufacturersService {
    Manufacturers addManufacturer(ManufacturersRequest request);
    Manufacturers getManufacturerByName(String name);
    Manufacturers getManufacturerById(Long manufacturerId);
    Manufacturers updateManufacturer(Long manufacturerId, ManufacturersRequest request);
    boolean deleteManufacturer(Long manufacturerId);
}
