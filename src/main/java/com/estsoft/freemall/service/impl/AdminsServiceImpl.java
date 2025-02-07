package com.estsoft.freemall.service.impl;

import com.estsoft.freemall.entity.Admins;
import com.estsoft.freemall.entity.Users;
import com.estsoft.freemall.repository.AdminsRepository;
import com.estsoft.freemall.service.AdminsService;
import com.estsoft.freemall.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminsServiceImpl implements AdminsService {
    private final AdminsRepository adminsRepository;
    private final UsersService usersService;

    @Override
    public Admins registerAdmin(Long userId) {
        Users user = usersService.getUserById(userId);

        if(user == null) {
            return null;
        }

        Admins admin = new Admins();
        admin.setUser(user);

        return adminsRepository.save(admin);
    }

    @Override
    public Admins getAdminById(Long adminId) {
        return adminsRepository.findById(adminId).orElse(null);
    }
}
