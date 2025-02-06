package com.estsoft.freemall.repository;

import com.estsoft.freemall.entity.PaymentMethodProviders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodProvidersRepository extends JpaRepository<PaymentMethodProviders, Long> {
}
