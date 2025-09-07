package com.example.sdpbackend.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serviceId;

    private String productName;      // Bills, Books, Calendars, etc.
    private String description;
    private int minOrderQuantity;
    private String turnaroundTime;

    @ElementCollection
    private List<String> sampleImages;   // multiple sample image URLs

    @ElementCollection
    private List<String> keyFeatures;    // Key features

    @ElementCollection
    private List<String> materials;      // Materials / specifications

    @ElementCollection
    private List<String> pricing;        // Pricing info
}
