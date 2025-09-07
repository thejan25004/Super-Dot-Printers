package com.example.sdpbackend.repo;

import com.example.sdpbackend.entity.PlaceOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceOrderRepository extends JpaRepository<PlaceOrder, Long> {
}
