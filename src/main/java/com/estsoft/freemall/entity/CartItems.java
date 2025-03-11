package com.estsoft.freemall.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CartItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Products product;

    @Column(nullable = false)
    private Integer quantity;

    @Column(name = "added_at", updatable = false, nullable = false)
    private LocalDateTime addedAt;

    public CartItems(Integer quantity) {
        this.quantity = quantity;
    }

    @PrePersist
    public void prePersist() {
        this.addedAt = LocalDateTime.now();
    }
}
