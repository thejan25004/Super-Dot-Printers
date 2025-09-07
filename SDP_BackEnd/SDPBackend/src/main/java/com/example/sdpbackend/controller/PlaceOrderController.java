//package com.example.sdpbackend.controller;
//
//import com.example.sdpbackend.dto.PlaceOrderDTO;
//import com.example.sdpbackend.service.PlaceOrderService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/orders")
//@RequiredArgsConstructor
//public class PlaceOrderController {
//
//    private final PlaceOrderService placeOrderService;
//
//    @PostMapping
//    public ResponseEntity<PlaceOrderDTO> createOrder(@RequestBody PlaceOrderDTO dto) {
//        return ResponseEntity.ok(placeOrderService.createOrder(dto));
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<PlaceOrderDTO> getOrder(@PathVariable Long id) {
//        return ResponseEntity.ok(placeOrderService.getOrderById(id));
//    }
//
//    @GetMapping
//    public ResponseEntity<List<PlaceOrderDTO>> getAllOrders() {
//        return ResponseEntity.ok(placeOrderService.getAllOrders());
//    }
//
////    @PutMapping("/{id}")
////    public ResponseEntity<PlaceOrderDTO> updateOrder(@PathVariable Long id, @RequestBody PlaceOrderDTO dto) {
////        return ResponseEntity.ok(placeOrderService.updateOrder(id, dto));
////    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
//        placeOrderService.deleteOrder(id);
//        return ResponseEntity.noContent().build();
//    }
//}
package com.example.sdpbackend.controller;

import com.example.sdpbackend.dto.PlaceOrderDTO;
import com.example.sdpbackend.service.PlaceOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class PlaceOrderController {

    private final PlaceOrderService placeOrderService;

    @PostMapping
    public ResponseEntity<PlaceOrderDTO> createOrder(@RequestBody PlaceOrderDTO dto) {
        return ResponseEntity.ok(placeOrderService.createOrder(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlaceOrderDTO> getOrder(@PathVariable Long id) {
        return ResponseEntity.ok(placeOrderService.getOrderById(id));
    }

    @GetMapping
    public ResponseEntity<List<PlaceOrderDTO>> getAllOrders() {
        return ResponseEntity.ok(placeOrderService.getAllOrders());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        placeOrderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
