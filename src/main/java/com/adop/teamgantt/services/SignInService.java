package com.adop.teamgantt.services;

import com.adop.teamgantt.controllers.SignInController;
import com.adop.teamgantt.models.CreateSignIn;
import com.adop.teamgantt.models.SignInBody;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SignInService {
    private final RestTemplate restTemplate;
    private final Gson gson;
    private final String TOKEN;

    @Autowired
    SignInService(final RestTemplate restTemplate,
                  final Gson gson,
                  @Value("${app.token}") final String TOKEN
    ) {
        this.restTemplate = restTemplate;
        this.gson = gson;
        this.TOKEN = TOKEN;
    }

    public SignInBody post(SignInController.PostRequest request) {
        final HttpHeaders httpRequestHeaderList = new HttpHeaders();
        httpRequestHeaderList.setContentType(MediaType.APPLICATION_JSON);
        httpRequestHeaderList.set("TG-Authorization", String.format("Bearer %s", TOKEN));

        final HttpEntity<String> httpRequest = new HttpEntity<>(
                gson.toJson(new CreateSignIn(
                        request.getUser(),
                        request.getPass()
                )),
                httpRequestHeaderList);
        final String response = restTemplate.postForObject("https://api.teamgantt.com/v1/authenticate", httpRequest, String.class);
        return gson.fromJson(response, SignInBody.class);
    }


}
