package com.estsoft.freemall.repository;

import com.estsoft.freemall.entity.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembershipRepository extends JpaRepository<Membership, Long> {
    Membership findByLevel(String level);
}
