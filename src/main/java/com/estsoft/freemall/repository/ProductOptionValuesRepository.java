package com.estsoft.freemall.repository;

import com.estsoft.freemall.entity.ProductOptionValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductOptionValuesRepository extends JpaRepository<ProductOptionValues, Long> {
}
