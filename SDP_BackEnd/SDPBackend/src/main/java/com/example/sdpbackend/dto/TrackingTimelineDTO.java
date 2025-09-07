package com.example.sdpbackend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrackingTimelineDTO {
    private Long id;
    private String status;
    private String note;
    private String updatedAt; // ISO String
    private Long orderId;
}
