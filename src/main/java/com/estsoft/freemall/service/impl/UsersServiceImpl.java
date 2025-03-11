package com.estsoft.freemall.service.impl;

import com.estsoft.freemall.dto.request.UsersRequest;
import com.estsoft.freemall.entity.Users;
import com.estsoft.freemall.repository.UsersRepository;
import com.estsoft.freemall.service.MembershipService;
import com.estsoft.freemall.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final MembershipService membershipService;

    private final String initialMembership = "Bronze";

    @Override
    public Users getUserById(Long id) {
        return usersRepository.findById(id).orElse(null);
    }

    @Override
    public Users register(UsersRequest request) {
        Users user = request.toEntity();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setMembership(membershipService.getMembership(initialMembership));
        return usersRepository.save(user);
    }

    @Override
    public Users login(String loginId, String password) {
        Users user = usersRepository.findByLoginIdAndDeletedAtIsNotNull(loginId);
        if(passwordEncoder.matches(password,user.getPassword())){
            user.updateLastLoginAt();
            return user;
        }
        return null;
    }

    @Override
    public Users update(Long userId, UsersRequest request) {
        Users user = usersRepository.findByIdAndDeletedAtIsNotNull(userId);
        if(user == null) {
            return null;
        }
        return usersRepository.save(request.updateEntity(user));
    }

    @Override
    public Users softDelete(Long userId) {
        Users user = usersRepository.findByIdAndDeletedAtIsNotNull(userId);
        if(user == null) {
            return null;
        }
        user.setDeletedAt(LocalDateTime.now());
        return usersRepository.save(user);
    }

    @Override
    public boolean delete(Long userId) {
        Users user = usersRepository.findByIdAndDeletedAtIsNotNull(userId);
        if(user == null) {
            return false;
        }
        usersRepository.delete(user);
        return true;
    }

    @Override
    public List<Users> getAllUsers() {
        return usersRepository.getAllByDeletedAtIsNotNull();
    }

    @Override
    public boolean isLoginIdDuplicate(String loginId) {
        return usersRepository.existsByLoginIdAndDeletedAtIsNotNull(loginId);
    }

    @Override
    public boolean isEmailDuplicate(String email) {
        return usersRepository.existsByEmailAndDeletedAtIsNotNull(email);
    }

    @Override
    public Users changePassword(Long userId, String currentPassword, String newPassword) {
        Users user = usersRepository.findByIdAndDeletedAtIsNotNull(userId);
        if(user == null) {
            return null;
        }
        if(passwordEncoder.matches(currentPassword,user.getPassword())) {
            user.setPassword(passwordEncoder.encode(newPassword));
        }
        return usersRepository.save(user);
    }
}
