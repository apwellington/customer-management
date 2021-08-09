package com.example.customermanagement.config;

import com.example.customermanagement.resource.dto.Response;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by Wellington Adames on 07/08/2021
 */
@Configuration
public class Beans {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    @Scope("prototype")
    public Response response(){
        return new Response();
    }

}
