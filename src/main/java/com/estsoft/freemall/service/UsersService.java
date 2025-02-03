package com.estsoft.freemall.service;

import com.estsoft.freemall.dto.request.UsersRequest;
import com.estsoft.freemall.entity.Users;

import java.util.List;

public interface UsersService {
    Users register(UsersRequest request);
    Users login(String loginId, String password);
    Users update(Long userId, UsersRequest request);
    void softDelete(Long userId);
    void delete(Long userId);
    List<Users> getAllUsers();

    boolean isLoginIdDuplicate(String loginId);
    boolean isEmailDuplicate(String email);

    boolean changePassword(Long userId, String currentPassword, String newPassword);
}
