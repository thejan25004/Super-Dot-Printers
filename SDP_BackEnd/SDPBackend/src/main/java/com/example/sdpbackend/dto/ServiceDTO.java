package com.example.sdpbackend.dto;

import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceDTO {
    private int serviceId;
    private String productName;
    private String description;
    private int minOrderQuantity;
    private String turnaroundTime;
    private List<String> sampleImages;
    private List<String> keyFeatures;
    private List<String> materials;
    private List<String> pricing;
}