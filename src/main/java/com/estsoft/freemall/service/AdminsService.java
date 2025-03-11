package com.estsoft.freemall.service;

import com.estsoft.freemall.entity.Admins;

public interface AdminsService {
    Admins registerAdmin(Long userId);
    Admins getAdminById(Long adminId);
}
