package com.example.sdpbackend.controller;

import com.example.sdpbackend.dto.TrackOrderDTO;
import com.example.sdpbackend.service.TrackOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tracking")
@RequiredArgsConstructor
public class TrackOrderController {

    private final TrackOrderService trackOrderService;

    @PostMapping
    public ResponseEntity<TrackOrderDTO> createTracking(@RequestBody TrackOrderDTO dto) {
        return ResponseEntity.ok(trackOrderService.createTracking(dto));
    }

    @GetMapping("/order/{placeOrderId}")
    public ResponseEntity<TrackOrderDTO> getTrackingByOrderId(@PathVariable Long placeOrderId) {
        return ResponseEntity.ok(trackOrderService.getTrackingByOrderId(placeOrderId));
    }


    @GetMapping("/order/all")
    public List<TrackOrderDTO> getAllTracking() {
        return trackOrderService.getAllTracking();
    }

}
