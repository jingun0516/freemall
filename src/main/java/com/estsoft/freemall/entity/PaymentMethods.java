package com.estsoft.freemall.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PaymentMethods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String method;

    @OneToMany(mappedBy = "paymentMethod" , cascade = CascadeType.ALL, orphanRemoval = true)
    List<PaymentMethodProviders> providers = new ArrayList<>();

    @Column(name = "is_active")
    private Boolean isActive = Boolean.TRUE;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public PaymentMethods(String method) {
        this.method = method;
    }

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }
}
