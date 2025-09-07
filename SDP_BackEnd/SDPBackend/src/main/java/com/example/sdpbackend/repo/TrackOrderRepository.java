package com.example.sdpbackend.repo;

import com.example.sdpbackend.entity.TrackOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrackOrderRepository extends JpaRepository<TrackOrder, Long> {
    Optional<TrackOrder> findByPlaceOrder_Id(Long placeOrderId); // search by PlaceOrder id
}
