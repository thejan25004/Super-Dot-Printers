package com.example.sdpbackend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contactId;

    private String name;        // Customer name
    private String email;       // Customer email
    private String subject;     // Subject of the message
    private String message;     // Message content
    private String phone;       // Optional phone number
}
