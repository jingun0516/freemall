package com.estsoft.freemall.entity;

import com.estsoft.freemall.enums.AdminLevel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Admins {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @Enumerated(EnumType.STRING)
    private AdminLevel level = AdminLevel.ADMIN;

    @Column(name = "registration_date", nullable = false)
    private LocalDateTime registrationDate;
}
