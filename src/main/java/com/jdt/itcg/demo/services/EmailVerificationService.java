package com.jdt.itcg.demo.services;

import com.jdt.itcg.demo.records.EmailValidationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmailVerificationService {

    @Value("${email.verification.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    public EmailValidationResponse verifyEmail(String email){
        if(email == null){
            throw new RuntimeException("Is not valid email");
        }
        URI uri = UriComponentsBuilder.fromUriString("https://emailvalidation.abstractapi.com/v1/")
                .queryParam("api_key", apiKey)
                .queryParam("email", email)
                .build().toUri();

        ResponseEntity<EmailValidationResponse> response = restTemplate.exchange(uri, HttpMethod.GET, null, EmailValidationResponse.class);

         if(response.getStatusCode().is5xxServerError()){
             throw new RuntimeException("Service not available");
         }

         return response.getBody();
    }

}
