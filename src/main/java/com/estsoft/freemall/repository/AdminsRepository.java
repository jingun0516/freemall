package com.estsoft.freemall.repository;

import com.estsoft.freemall.entity.Admins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminsRepository extends JpaRepository<Admins, Long> {
}
