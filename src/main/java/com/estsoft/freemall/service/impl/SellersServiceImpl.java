package com.estsoft.freemall.service.impl;

import com.estsoft.freemall.dto.request.SellersRequest;
import com.estsoft.freemall.entity.Sellers;
import com.estsoft.freemall.entity.Users;
import com.estsoft.freemall.repository.SellersRepository;
import com.estsoft.freemall.service.SellersService;
import com.estsoft.freemall.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SellersServiceImpl implements SellersService {
    private final SellersRepository sellersRepository;
    private final UsersService usersService;

    @Override
    public Sellers registerSeller(Long userId, SellersRequest request) {
        Users user = usersService.getById(userId);
        if(user == null) {
            return null;
        }
        Sellers sellers = request.toEntity();
        sellers.setUser(user);

        return sellersRepository.save(sellers);
    }

    @Override
    public Sellers getSellerById(Long sellerId) {
        return sellersRepository.findById(sellerId).orElse(null);
    }
}
