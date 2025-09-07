package com.example.sdpbackend.service;

import com.example.sdpbackend.dto.TrackingTimelineDTO;
import com.example.sdpbackend.entity.PlaceOrder;
import com.example.sdpbackend.entity.TrackingTimeline;
import com.example.sdpbackend.repo.PlaceOrderRepository;
import com.example.sdpbackend.repo.TrackingTimelineRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TrackingTimelineService {

    private final TrackingTimelineRepo trackingTimelineRepo;

    private final PlaceOrderRepository placeOrderRepo;

    public TrackingTimelineDTO addTracking(Long orderId, String status, String note) {
        PlaceOrder order = placeOrderRepo.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        TrackingTimeline timeline = TrackingTimeline.builder()
                .status(status)
                .note(note)
                .updatedAt(LocalDateTime.now())
                .placeOrder(order)
                .build();

        trackingTimelineRepo.save(timeline);

        return TrackingTimelineDTO.builder()
                .id(timeline.getId())
                .status(timeline.getStatus())
                .note(timeline.getNote())
                .updatedAt(timeline.getUpdatedAt().toString())
                .orderId(order.getId())
                .build();
    }

    public List<TrackingTimelineDTO> getTrackingByOrder(Long orderId) {
        return trackingTimelineRepo.findByPlaceOrderId(orderId).stream()
                .map(t -> TrackingTimelineDTO.builder()
                        .id(t.getId())
                        .status(t.getStatus())
                        .note(t.getNote())
                        .updatedAt(t.getUpdatedAt().toString())
                        .orderId(orderId)
                        .build())
                .collect(Collectors.toList());
    }
}
