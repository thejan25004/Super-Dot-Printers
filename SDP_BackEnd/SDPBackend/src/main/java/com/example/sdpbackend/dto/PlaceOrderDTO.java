//package com.example.sdpbackend.dto;
//
//import lombok.*;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class PlaceOrderDTO {
//    private Long id;
//    private Long userId;
//    private Long serviceId;
//    private int quantity;
//    private String deadline;
//    private String specialInstructions;
//    private String designFilePath;
//    private long phoneNumber;
//}
package com.example.sdpbackend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlaceOrderDTO {
    private Long id;
    private Long userId;
    private Long serviceId;
    private int quantity;
    private String deadline;
    private String specialInstructions;
    private String designFilePath;
    private long phoneNumber;

    // 👉 New field
    private String destinationAddress;
}
