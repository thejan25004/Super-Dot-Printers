package com.example.sdpbackend.service;

import com.example.sdpbackend.dto.TrackOrderDTO;
import com.example.sdpbackend.entity.PlaceOrder;
import com.example.sdpbackend.entity.TrackOrder;
import com.example.sdpbackend.entity.User;
import com.example.sdpbackend.repo.PlaceOrderRepository;
import com.example.sdpbackend.repo.TrackOrderRepository;
import com.example.sdpbackend.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TrackOrderService {

    private final TrackOrderRepository trackOrderRepository;
    private final PlaceOrderRepository placeOrderRepository;
    private final UserRepo userRepository;

    // Create tracking entry
    public TrackOrderDTO createTracking(TrackOrderDTO dto) {
        PlaceOrder placeOrder = placeOrderRepository.findById(dto.getPlaceOrderId())
                .orElseThrow(() -> new RuntimeException("PlaceOrder not found"));

        User user = userRepository.findById(dto.getUserId().intValue())
                .orElseThrow(() -> new RuntimeException("User not found"));

        TrackOrder trackOrder = TrackOrder.builder()
                .placeOrder(placeOrder)
                .user(user)
                .status(dto.getStatus())
                .carrier(dto.getCarrier())
                .estimatedDelivery(dto.getEstimatedDelivery())
                .currentLocation(dto.getCurrentLocation())
                .build();

        return mapToDTO(trackOrderRepository.save(trackOrder));
    }

    // Search tracking by PlaceOrder ID
    public TrackOrderDTO getTrackingByOrderId(Long placeOrderId) {
        TrackOrder trackOrder = trackOrderRepository.findByPlaceOrder_Id(placeOrderId)
                .orElseThrow(() -> new RuntimeException("Tracking info not found for order: " + placeOrderId));
        return mapToDTO(trackOrder);
    }

    // ✅ Get all trackings
    public List<TrackOrderDTO> getAllTracking() {
        return trackOrderRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }
    private TrackOrderDTO mapToDTO(TrackOrder trackOrder) {
        return TrackOrderDTO.builder()
                .id(trackOrder.getId())
                .placeOrderId(trackOrder.getPlaceOrder().getId())
                .userId((long) trackOrder.getUser().getUserId())
                .status(trackOrder.getStatus())
                .carrier(trackOrder.getCarrier())
                .estimatedDelivery(trackOrder.getEstimatedDelivery())
                .currentLocation(trackOrder.getCurrentLocation())
                .build();
    }
}
