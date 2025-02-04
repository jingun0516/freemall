package com.estsoft.freemall.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class UserCoupons {
    @Id
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @Id
    @ManyToOne
    @JoinColumn(name = "coupon_id", nullable = false)
    private Coupons coupon;

    @Column(nullable = false)
    private Boolean isUsed;

    @Column(name = "used_at")
    private LocalDateTime usedAt;
}
