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
public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String level;

    @Column
    private String benefits;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Membership(String level, String benefits) {
        this.level = level;
        if (!benefits.isEmpty()) {
            this.benefits = benefits;
        }
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
}
