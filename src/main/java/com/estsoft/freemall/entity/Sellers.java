package com.estsoft.freemall.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Sellers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @Column(name = "store_name", nullable = false, unique = true)
    private String storeName;

    @Column(name = "store_description")
    private String storeDescription;

    @Column(name = "registration_date", nullable = false)
    private LocalDateTime registrationDate;

    @OneToMany(mappedBy = "seller")
    private List<Products> products;

    @PrePersist
    public void prePersist(){
        registrationDate = LocalDateTime.now();
    }

    public Sellers(String storeName, String storeDescription) {
        this.storeName = storeName;
        this.storeDescription = storeDescription;
    }
}
