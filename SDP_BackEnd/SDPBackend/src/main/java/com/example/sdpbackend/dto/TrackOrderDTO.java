package com.example.sdpbackend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrackOrderDTO {
    private Long id;
    private Long placeOrderId;
    private Long userId;
    private String status;
    private String carrier;
    private String estimatedDelivery;
    private String currentLocation;
}
