package com.example.customermanagement.resource.dto;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Wellington Adames on 08/08/2021
 */
public class Response {
    public Map<String, Object> response;

    public Response() {
        this.response = new HashMap<>();
        this.response.put("date", LocalDateTime.now());
        this.response.put("error", false);
    }
}
