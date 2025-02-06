package com.estsoft.freemall.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "product_option_values",
        uniqueConstraints = {
                @UniqueConstraint(name = "unique_product_option_value",
                        columnNames = {"product_option_id", "value"})
        })
public class ProductOptionValues {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_option_id", nullable = false)
    private ProductOptions productOption;

    private String value;

    public ProductOptionValues(String value) {
        this.value = value;
    }
}
