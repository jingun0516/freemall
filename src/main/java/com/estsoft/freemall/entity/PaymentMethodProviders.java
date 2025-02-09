package com.estsoft.freemall.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = {"payment_method_id", "provider"})
)
@NoArgsConstructor
public class PaymentMethodProviders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "payment_method_id")
    private PaymentMethods paymentMethod;

    @Column(name = "is_active")
    private Boolean isActive = Boolean.TRUE;

    @Column
    private String provider;

    public PaymentMethodProviders(String provider) {
        this.provider = provider;
    }
}
