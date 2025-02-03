package com.estsoft.freemall.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ProductKeywords {
    @Id
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Products product;

    @Id
    @ManyToOne
    @JoinColumn(name = "keyword_id", nullable = false)
    private Keywords keyword;
}
