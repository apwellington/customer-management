package com.example.customermanagement.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Wellington Adames on 07/08/2021
 */
@Configuration
public class Beans {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }


}
