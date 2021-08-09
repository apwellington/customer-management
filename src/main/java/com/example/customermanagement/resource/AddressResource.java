package com.example.customermanagement.resource;

import com.example.customermanagement.entity.Address;
import com.example.customermanagement.exceptions.AddressException;
import com.example.customermanagement.exceptions.CustomerException;
import com.example.customermanagement.resource.dto.AddressDto;
import com.example.customermanagement.resource.dto.CustomerDto;
import com.example.customermanagement.resource.dto.Response;
import com.example.customermanagement.services.IAddressService;
import com.example.customermanagement.util.GenericMapper;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Wellington Adames on 07/08/2021
 */
@RestController
@RequestMapping("/address")
public class AddressResource extends AbstractResource<AddressDto, Long>{

    private final Logger logger = LoggerFactory.getLogger(AddressResource.class);

    private final ModelMapper modelMapper;
    private final IAddressService addressService;

    public AddressResource(ModelMapper modelMapper, IAddressService addressService) {
        logger.info("init AddressResource");
        this.modelMapper = modelMapper;
        this.addressService = addressService;
    }


    @Override
    public ResponseEntity<Response> create(@RequestBody AddressDto addressDto, Response response) {
        Address addressEntity = GenericMapper.map(addressDto, Address.class, modelMapper);
        AddressDto addressDto1 = null;
        try {
            logger.debug(String.format("create(%s)" , addressDto.toString()));
            addressDto1 = GenericMapper.map(this.addressService.create(addressEntity), AddressDto.class, modelMapper);
            response.response.put("data", addressDto1);
            response.response.put("message", HttpStatus.OK.getReasonPhrase());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (AddressException e) {
            e.printStackTrace();
            response.response.put("message", e.getMessage());
            response.response.put("error", true);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Response> delete(@PathVariable Long addressId, Response response) {
        try {
            logger.debug(String.format("delete(%s)" , addressId));
            this.addressService.deleteById(addressId);
            response.response.put("data", 1);
            response.response.put("message", HttpStatus.OK.getReasonPhrase());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (AddressException e){
            e.printStackTrace();
            e.printStackTrace();
            response.response.put("message", e.getMessage());
            response.response.put("error", true);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Response> update(@RequestBody AddressDto addressDto, @PathVariable Long aLong, Response response) {
        Address addressEntity = GenericMapper.map(addressDto, Address.class, modelMapper);
        try {
            logger.debug(String.format("update(%s)" , addressDto.toString()));
            AddressDto addressDto1 = GenericMapper.map(this.addressService.update(addressEntity), AddressDto.class, modelMapper);
            response.response.put("data", addressDto1);
            response.response.put("message", HttpStatus.OK.getReasonPhrase());
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (AddressException e) {
            e.printStackTrace();
            response.response.put("message", e.getMessage());
            response.response.put("error", true);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Response> findAll(Response response) {
        try{
            List<AddressDto> addressDtos = GenericMapper.mapCollection(addressService.findAll(), AddressDto.class, modelMapper);
            response.response.put("data", addressDtos);
            response.response.put("message", HttpStatus.OK.getReasonPhrase());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (AddressException ex){
            ex.printStackTrace();
            response.response.put("message", ex.getMessage());
            response.response.put("error", true);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<Response> findAll(@Autowired Response response, @PathVariable Long customerId) {
        try {
            logger.debug(String.format("findAll(%s)" , customerId));
            logger.debug(String.format(""));
            List<AddressDto> addressDtos = GenericMapper.mapCollection(this.addressService.findByCustomerId(customerId), AddressDto.class,modelMapper);
            response.response.put("data", addressDtos);
            response.response.put("message", HttpStatus.OK.getReasonPhrase());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (AddressException e) {
            e.printStackTrace();
            response.response.put("message", e.getMessage());
            response.response.put("error", true);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Response> findById(@PathVariable("id") Long id, Response response) {
        try {
            logger.debug(String.format("findById(%s)" , id));
            AddressDto addressDto = GenericMapper.map(this.addressService.findById(id), AddressDto.class,modelMapper);
            response.response.put("data", addressDto);
            response.response.put("message", HttpStatus.OK.getReasonPhrase());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (AddressException e) {
            e.printStackTrace();
            response.response.put("message", e.getMessage());
            response.response.put("error", true);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}
