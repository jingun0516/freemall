package com.estsoft.freemall.repository;

import com.estsoft.freemall.entity.Manufacturers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturersRepository extends JpaRepository<Manufacturers, Long> {
    Manufacturers findByName(String name);
}
