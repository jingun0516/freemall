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

    @Override
    public Manufacturers getManufacturerById(Long manufacturerId) {
        return manufacturersRepository.findById(manufacturerId).orElse(null);
    }

    @Override
    public Manufacturers updateManufacturer(Long manufacturerId, ManufacturersRequest request) {
        Manufacturers manufacturer = getManufacturerById(manufacturerId);
        if(manufacturer==null){
            return null;
        }
        request.updateEntity(manufacturer);

        return manufacturersRepository.save(manufacturer);
    }

    @Override
    public boolean deleteManufacturer(Long manufacturerId) {
        Manufacturers manufacturer = getManufacturerById(manufacturerId);
        if(manufacturer==null){
            return false;
        }

        manufacturersRepository.deleteById(manufacturerId);
        return true;
    }
}
