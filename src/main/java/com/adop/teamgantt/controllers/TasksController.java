package com.adop.teamgantt.controllers;

import com.adop.teamgantt.services.TasksService;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tasks")
public class TasksController {

    @Autowired
    TasksService service;


    @PostMapping("get-tasks")
    public ResponseEntity<HttpStatus> getTasks(
            @RequestBody final PostRequest request
    ) {
        this.service.getTasks(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> post(
            @RequestBody final PostRequest request
    ) {
        this.service.post(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Data
    @NoArgsConstructor
    public static class PostRequest {
        @JsonProperty("TGAuthorization")
        private String TGAuthorization;

        @JsonProperty("TGApiKey")
        private String TGApiKey;

        @JsonProperty("TGUserToken")
        private String TGUserToken;
    }


}
