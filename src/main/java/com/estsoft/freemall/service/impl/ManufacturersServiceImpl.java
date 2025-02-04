package com.estsoft.freemall.service.impl;

import com.estsoft.freemall.dto.request.ManufacturersRequest;
import com.estsoft.freemall.entity.Manufacturers;
import com.estsoft.freemall.repository.ManufacturersRepository;
import com.estsoft.freemall.service.ManufacturersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ManufacturersServiceImpl implements ManufacturersService {
    private final ManufacturersRepository manufacturersRepository;

    @Override
    public Manufacturers addManufacturer(ManufacturersRequest request) {
        return manufacturersRepository.save(request.toEntity());
    }

    @Override
    public Manufacturers getManufacturerByName(String name) {
        return manufacturersRepository.findByName(name);
    }
}
