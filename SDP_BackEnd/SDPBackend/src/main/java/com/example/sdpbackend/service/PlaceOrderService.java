
package com.example.sdpbackend.service;

import com.example.sdpbackend.dto.PlaceOrderDTO;
import com.example.sdpbackend.entity.PlaceOrder;
import com.example.sdpbackend.entity.Service;
import com.example.sdpbackend.entity.User;
import com.example.sdpbackend.repo.PlaceOrderRepository;
import com.example.sdpbackend.repo.ServiceRepo;
import com.example.sdpbackend.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class PlaceOrderService {

    @Autowired
    private PlaceOrderRepository placeOrderRepository;

    @Autowired
    private UserRepo userRepository;

    @Autowired
    private ServiceRepo serviceRepository;

    // Create Order
    public PlaceOrderDTO createOrder(PlaceOrderDTO dto) {
        User user = userRepository.findById(dto.getUserId().intValue())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Service service = serviceRepository.findById(Math.toIntExact(dto.getServiceId()))
                .orElseThrow(() -> new RuntimeException("Service not found"));

        PlaceOrder order = PlaceOrder.builder()
                .user(user)
                .service(service)
                .quantity(dto.getQuantity())
                .deadline(dto.getDeadline())
                .specialInstructions(dto.getSpecialInstructions())
                .designFilePath(dto.getDesignFilePath())
                .phoneNumber(dto.getPhoneNumber())
                .destinationAddress(dto.getDestinationAddress()) // 👉 mapping
                .build();

        PlaceOrder saved = placeOrderRepository.save(order);
        return mapToDTO(saved);
    }

    // Get Order by Id
    public PlaceOrderDTO getOrderById(Long id) {
        PlaceOrder order = placeOrderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        return mapToDTO(order);
    }

    // Get All Orders
    public List<PlaceOrderDTO> getAllOrders() {
        return placeOrderRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // Delete Order
    public void deleteOrder(Long id) {
        placeOrderRepository.deleteById(id);
    }

    // Map Entity → DTO
    private PlaceOrderDTO mapToDTO(PlaceOrder order) {
        return PlaceOrderDTO.builder()
                .id(order.getId())
                .userId((long) order.getUser().getUserId()) // int → Long
                .serviceId((long) order.getService().getServiceId()) // int → Long
                .quantity(order.getQuantity())
                .deadline(order.getDeadline())
                .specialInstructions(order.getSpecialInstructions())
                .designFilePath(order.getDesignFilePath())
                .phoneNumber(order.getPhoneNumber())
                .destinationAddress(order.getDestinationAddress()) // 👉 mapping
                .build();
    }
}
