package com.example.sdpbackend.service;

import com.example.sdpbackend.dto.ServiceDTO;
import com.example.sdpbackend.entity.Service;
import com.example.sdpbackend.repo.ServiceRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class ServiceService {

    @Autowired
    private ServiceRepo serviceRepo;

    @Autowired
    private ModelMapper modelMapper;

    // Add service
    public ServiceDTO addService(ServiceDTO serviceDTO){
        Service service = modelMapper.map(serviceDTO, Service.class);
        Service saved = serviceRepo.save(service);
        return modelMapper.map(saved, ServiceDTO.class);
    }

    // Update service
    public ServiceDTO updateService(ServiceDTO serviceDTO){
        Optional<Service> optional = serviceRepo.findById(serviceDTO.getServiceId());
        if(optional.isPresent()){
            Service service = optional.get();
            service.setProductName(serviceDTO.getProductName());
            service.setDescription(serviceDTO.getDescription());
            service.setMinOrderQuantity(serviceDTO.getMinOrderQuantity());
            service.setTurnaroundTime(serviceDTO.getTurnaroundTime());
            service.setSampleImages(serviceDTO.getSampleImages());
            service.setKeyFeatures(serviceDTO.getKeyFeatures());
            service.setMaterials(serviceDTO.getMaterials());
            service.setPricing(serviceDTO.getPricing());
            Service updated = serviceRepo.save(service);
            return modelMapper.map(updated, ServiceDTO.class);
        }
        return null;
    }

    // Delete service
    public boolean deleteService(int serviceId){
        if(serviceRepo.existsById(serviceId)){
            serviceRepo.deleteById(serviceId);
            return true;
        }
        return false;
    }

    // Get by ID
    public ServiceDTO getServiceById(int serviceId){
        return serviceRepo.findById(serviceId)
                .map(service -> modelMapper.map(service, ServiceDTO.class))
                .orElse(null);
    }

    // Get all
    public List<ServiceDTO> getAllServices(){
        return serviceRepo.findAll().stream()
                .map(service -> modelMapper.map(service, ServiceDTO.class))
                .collect(Collectors.toList());
    }
}
