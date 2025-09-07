package com.example.sdpbackend.controller;



import com.example.sdpbackend.dto.ServiceDTO;
import com.example.sdpbackend.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/service")
@CrossOrigin
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @PostMapping("/save")
    public ResponseEntity<ServiceDTO> addService(@RequestBody ServiceDTO serviceDTO){
        return new ResponseEntity<>(serviceService.addService(serviceDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<ServiceDTO> updateService(@RequestBody ServiceDTO serviceDTO){
        return new ResponseEntity<>(serviceService.updateService(serviceDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteService(@PathVariable int id){
        boolean deleted = serviceService.deleteService(id);
        return new ResponseEntity<>(deleted ? "Deleted Successfully" : "Service Not Found", HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ServiceDTO>> getAllServices(){
        return new ResponseEntity<>(serviceService.getAllServices(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceDTO> getServiceById(@PathVariable int id){
        return new ResponseEntity<>(serviceService.getServiceById(id), HttpStatus.OK);
    }
}
