package com.estsoft.freemall.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Discounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Products product;

    @Column(name = "discount_rate")
    private BigDecimal discountRate;

    @Column(name = "discount_price")
    private BigDecimal discountPrice;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @PrePersist
    @PreUpdate
    public void validateDiscount() {
        // discount_rate 또는 discount_price가 반드시 있어야 함
        if (discountRate == null && discountPrice == null) {
            throw new IllegalArgumentException("Either discount_rate or discount_price must be provided.");
        }
    }
}
