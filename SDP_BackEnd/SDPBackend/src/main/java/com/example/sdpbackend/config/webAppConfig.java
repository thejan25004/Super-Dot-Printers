package com.example.sdpbackend.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class webAppConfig {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
