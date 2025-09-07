package com.example.sdpbackend.dto;

import com.example.sdpbackend.entity.HeardAboutOption;
import com.example.sdpbackend.entity.RecommendOption;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TestimonialDTO {
    private Long id;

    private int userId;
    private String userName;
    private String authorPhoto;
    private String companyName;
    private int rating;
    private String message;
    private RecommendOption recommend;
    private HeardAboutOption heardAbout;
    private boolean allowPublic;
    private String serviceFeedback;
}
