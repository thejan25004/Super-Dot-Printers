package com.example.sdpbackend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    private String role; // USER / ADMIN

    private String profilePictureUrl; // <-- Google picture url (photoURL)
}
