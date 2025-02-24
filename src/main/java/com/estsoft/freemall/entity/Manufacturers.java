package com.estsoft.freemall.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Manufacturers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column
    private String description;

    public Manufacturers(String name, String description) {
        this.name = name;
        if(!description.isEmpty()) {
            this.description = description;
        }
    }

    public void update(String name, String description) {
        if(name != null) {
            this.name = name;
        }
        if(description != null) {
            this.description = description;
        }
    }
}
