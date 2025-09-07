package com.example.sdpbackend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrackOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Connect to PlaceOrder
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_order_id", nullable = false)
    private PlaceOrder placeOrder;

    // Connect to User (to know who placed)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String status;   // e.g. Processing, Shipped, Delivered
    private String carrier;  // e.g. Express Delivery
    private String estimatedDelivery; // e.g. 2025-09-05
    private String currentLocation;   // optional (e.g. "Colombo Hub")
}
