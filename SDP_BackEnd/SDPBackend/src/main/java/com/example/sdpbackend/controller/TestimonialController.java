package com.example.sdpbackend.controller;

import com.example.sdpbackend.dto.TestimonialDTO;
import com.example.sdpbackend.service.TestimonialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/testimonials")
@CrossOrigin
public class TestimonialController {

    @Autowired
    private TestimonialService testimonialService;

    @PostMapping
    public ResponseEntity<TestimonialDTO> save(@RequestBody TestimonialDTO dto) {
        return ResponseEntity.ok(testimonialService.saveTestimonial(dto));
    }

    @GetMapping
    public ResponseEntity<List<TestimonialDTO>> getAll() {
        return ResponseEntity.ok(testimonialService.getAllTestimonials());
    }
}
