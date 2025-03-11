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
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique=true, nullable = false)
    private String name;

    @Column
    private String description;

    @OneToOne
    @JoinColumn(name = "parent_category_id")
    private Categories categories;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Categories(String name, String description) {
        this.name = name;
        if(description != null) {
            this.description = description;
        }
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
}
