package com.adop.teamgantt.controllers;

import com.adop.teamgantt.models.SignInBody;
import com.adop.teamgantt.services.SignInService;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/signin")
public class SignInController {

    @Autowired
    SignInService service;

    @PostMapping
    public SignInBody post(@RequestBody final PostRequest request) {
        return this.service.post(request);
    }

    @Data
    @NoArgsConstructor
    public static class PostRequest {
        @JsonProperty("user")
        private String user;

        @JsonProperty("pass")
        private String pass;
    }

}
