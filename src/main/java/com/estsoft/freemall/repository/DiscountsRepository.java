package com.estsoft.freemall.repository;

import com.estsoft.freemall.entity.Discounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscountsRepository extends JpaRepository<Discounts, Long> {
    List<Discounts> findByProductId(Long productId);
}
