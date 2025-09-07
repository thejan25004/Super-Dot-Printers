package com.example.sdpbackend.repo;

import com.example.sdpbackend.entity.TrackingTimeline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackingTimelineRepo extends JpaRepository<TrackingTimeline, Long> {
    List<TrackingTimeline> findByPlaceOrderId(Long orderId);
}
