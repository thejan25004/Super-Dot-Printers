package com.example.sdpbackend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {
    private int userId;
    private String name;
    private String email;
    private String password;
    private String role; // USER / ADMIN
}
