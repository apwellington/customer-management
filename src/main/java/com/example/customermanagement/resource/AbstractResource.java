package com.example.customermanagement.resource;

import com.example.customermanagement.resource.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Wellington Adames on 08/08/2021
 */
public abstract class AbstractResource<C, T> {

    @PostMapping({"/", ""})
    public abstract ResponseEntity<Response> create(@RequestBody C c, @Autowired Response response);

    @DeleteMapping("/{id}")
    public abstract ResponseEntity<Response> delete(@PathVariable T t, @Autowired Response response);

    @PutMapping("/{id}")
    public abstract ResponseEntity<Response> update(@RequestBody C c, @PathVariable T t, @Autowired Response response);

    @GetMapping({"/", ""})
    public abstract ResponseEntity<Response>findAll(@Autowired Response response);

    @GetMapping("/{id}")
    public abstract ResponseEntity<Response> findById(@PathVariable("id") T t, @Autowired Response response);

}
