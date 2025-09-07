//package com.example.sdpbackend.entity;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class PlaceOrder {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    // Link to User (Name + Email + Phone)
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;
//
//    // Link to Service (Product Type)
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "service_id", nullable = false)
//    private Service service;
//
//    private int quantity;
//
//    private String deadline;
//
//    private String specialInstructions;
//
//    private String designFilePath; // uploaded file path (optional)
//
//    private long phoneNumber; // Customer phone number
//}
package com.example.sdpbackend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlaceOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Link to User (Name + Email + Phone)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Link to Service (Product Type)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;

    private int quantity;

    private String deadline;

    private String specialInstructions;

    private String designFilePath; // uploaded file path (optional)

    private long phoneNumber; // Customer phone number

    // 👉 New field
    private String destinationAddress;

    @OneToMany(mappedBy = "placeOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TrackingTimeline> trackingTimeline = new ArrayList<>();

}
