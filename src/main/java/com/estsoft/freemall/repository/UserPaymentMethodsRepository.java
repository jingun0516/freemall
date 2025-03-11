package com.estsoft.freemall.repository;

import com.estsoft.freemall.entity.UserPaymentMethods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPaymentMethodsRepository extends JpaRepository<UserPaymentMethods, Long> {
    UserPaymentMethods findByUserId(Long userId);
}
