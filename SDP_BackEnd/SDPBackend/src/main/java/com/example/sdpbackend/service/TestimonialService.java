package com.example.sdpbackend.service;

import com.example.sdpbackend.dto.TestimonialDTO;
import com.example.sdpbackend.entity.Testimonial;
import com.example.sdpbackend.entity.User;
import com.example.sdpbackend.repo.TestimonialRepo;
import com.example.sdpbackend.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestimonialService {

    @Autowired
    private TestimonialRepo testimonialRepo;

    @Autowired
    private UserRepo userRepo;

    public TestimonialDTO saveTestimonial(TestimonialDTO dto) {
        User user = userRepo.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Testimonial testimonial = new Testimonial();
        testimonial.setUser(user);
        testimonial.setCompanyName(dto.getCompanyName());
        testimonial.setRating(dto.getRating());
        testimonial.setMessage(dto.getMessage());
        testimonial.setRecommend(dto.getRecommend());
        testimonial.setHeardAbout(dto.getHeardAbout());
        testimonial.setAllowPublic(dto.isAllowPublic());
        testimonial.setServiceFeedback(dto.getServiceFeedback());

        Testimonial saved = testimonialRepo.save(testimonial);
        return mapToDTO(saved);
    }

    public List<TestimonialDTO> getAllTestimonials() {
        return testimonialRepo.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private TestimonialDTO mapToDTO(Testimonial testimonial) {
        return TestimonialDTO.builder()
                .id(testimonial.getId())
                .userId(testimonial.getUser().getUserId())
                .userName(testimonial.getUser().getName())
                .authorPhoto(testimonial.getUser().getProfilePictureUrl())
                .companyName(testimonial.getCompanyName())
                .rating(testimonial.getRating())
                .message(testimonial.getMessage())
                .recommend(testimonial.getRecommend())
                .heardAbout(testimonial.getHeardAbout())
                .allowPublic(testimonial.isAllowPublic())
                .serviceFeedback(testimonial.getServiceFeedback())
                .build();
    }
}
