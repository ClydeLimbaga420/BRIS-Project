package com.BRIS.Bris.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user_login")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;
}
