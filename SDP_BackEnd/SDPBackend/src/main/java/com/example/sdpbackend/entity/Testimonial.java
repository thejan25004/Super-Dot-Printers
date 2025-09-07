package com.example.sdpbackend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "testimonials")
public class Testimonial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Link to User (for name/email/profile photo auto load)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String companyName;

    private int rating;

    @Column(columnDefinition = "TEXT")
    private String message;

    @Enumerated(EnumType.STRING)
    private RecommendOption recommend;

    @Enumerated(EnumType.STRING)
    private HeardAboutOption heardAbout;

    private boolean allowPublic;

    // 🔥 New Column: Service Feedback (related to service categories like "Quantum Printing")
    private String serviceFeedback;
}
