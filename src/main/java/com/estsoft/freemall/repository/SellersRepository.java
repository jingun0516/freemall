package com.estsoft.freemall.repository;

import com.estsoft.freemall.entity.Sellers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellersRepository extends JpaRepository<Sellers, Long> {
}
