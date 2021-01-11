package com.adop.teamgantt;

import com.adop.teamgantt.configs.gson.ZonedDateTimeDeserializer;
import com.adop.teamgantt.configs.gson.ZonedDateTimeSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.time.ZonedDateTime;

@SpringBootApplication
public class TeamganttApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeamganttApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public Gson getGson() {
        final GsonBuilder gsonBuilder = new GsonBuilder()
                .registerTypeAdapter(ZonedDateTime.class, new ZonedDateTimeSerializer())
                .registerTypeAdapter(ZonedDateTime.class, new ZonedDateTimeDeserializer());
        return gsonBuilder.create();
    }

}
