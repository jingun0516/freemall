package com.estsoft.freemall.repository;

import com.estsoft.freemall.entity.ProductOptions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductOptionsRepository extends JpaRepository<ProductOptions, Long> {
}
