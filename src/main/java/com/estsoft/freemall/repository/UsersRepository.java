package com.estsoft.freemall.repository;

import com.estsoft.freemall.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    List<Users> getAllByDeletedAtIsNotNull();
    Users findByIdAndDeletedAtIsNotNull(Long id);
    Users findByLoginIdAndDeletedAtIsNotNull(String loginId);
    boolean existsByLoginIdAndDeletedAtIsNotNull(String loginId);
    boolean existsByEmailAndDeletedAtIsNotNull(String email);
}
