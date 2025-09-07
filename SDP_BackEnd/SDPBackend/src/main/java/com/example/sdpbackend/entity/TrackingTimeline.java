package com.example.sdpbackend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrackingTimeline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;  // e.g., "PLACED", "PROCESSING", "PRINTING", "DELIVERED"
    private String note;    // optional: "Sent to printing dept"
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private PlaceOrder placeOrder;
}
