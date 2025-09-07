package com.example.sdpbackend.controller;

import com.example.sdpbackend.dto.TrackingTimelineDTO;
import com.example.sdpbackend.service.TrackingTimelineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tracking")
@RequiredArgsConstructor
public class TrackingTimelineController {

    private final TrackingTimelineService trackingTimelineService;

    @PostMapping("/{orderId}")
    public TrackingTimelineDTO addTracking(@PathVariable Long orderId,
                                           @RequestParam String status,
                                           @RequestParam(required = false) String note) {
        return trackingTimelineService.addTracking(orderId, status, note);
    }

    @GetMapping("/{orderId}")
    public List<TrackingTimelineDTO> getTracking(@PathVariable Long orderId) {
        return trackingTimelineService.getTrackingByOrder(orderId);
    }
}
