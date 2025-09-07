package com.example.sdpbackend.repo;

import com.example.sdpbackend.entity.Testimonial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface TestimonialRepo extends JpaRepository<Testimonial, Long> {
    List<Testimonial> findByAllowPublicTrue();
}
