package com.example.sdpbackend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ContactDTO {

    private String name;
    private String email;
    private String subject;
    private String message;
    private String phone;
}
