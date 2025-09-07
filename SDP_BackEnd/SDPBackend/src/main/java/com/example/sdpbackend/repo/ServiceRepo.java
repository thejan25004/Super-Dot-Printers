package com.example.sdpbackend.repo;



import com.example.sdpbackend.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ServiceRepo extends JpaRepository<Service, Integer> {
//    Optional<Object> findById(Long serviceId);
}