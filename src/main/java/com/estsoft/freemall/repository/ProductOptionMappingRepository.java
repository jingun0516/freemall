package com.estsoft.freemall.repository;

import com.estsoft.freemall.entity.ProductOptionMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductOptionMappingRepository extends JpaRepository<ProductOptionMapping, Long> {
}
