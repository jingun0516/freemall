package com.estsoft.freemall.repository;

import com.estsoft.freemall.entity.Coupons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponsRepository extends JpaRepository<Coupons, Long> {
}
