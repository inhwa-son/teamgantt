package com.adop.teamgantt.services;

import com.adop.teamgantt.controllers.TasksController;
import com.adop.teamgantt.models.CreateTasksPost;
import com.adop.teamgantt.models.TasksBody;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TasksService {
    private final RestTemplate restTemplate;
    private final Gson gson;
    private final String TOKEN;

    @Autowired
    TasksService(final RestTemplate restTemplate,
                 final Gson gson,
                 @Value("${app.token}") final String TOKEN
    ) {
        this.restTemplate = restTemplate;
        this.gson = gson;
        this.TOKEN = TOKEN;
    }

    public HttpHeaders CreateHeaders(TasksController.PostRequest request) {
        final HttpHeaders httpRequestHeaderList = new HttpHeaders();
        httpRequestHeaderList.setContentType(MediaType.APPLICATION_JSON);
        httpRequestHeaderList.set("accept", "");
        httpRequestHeaderList.set("TG-Authorization", String.format("Bearer %s", TOKEN));
//        httpRequestHeaderList.set("TG-Authorization", request.getTGAuthorization());
        httpRequestHeaderList.set("TG-Api-Key", request.getTGApiKey());
        httpRequestHeaderList.set("TG-User-Token", request.getTGUserToken());
        return httpRequestHeaderList;
    }

    public void post(TasksController.PostRequest request) {
        final HttpHeaders httpRequestHeaderList = this.CreateHeaders(request);
        final HttpEntity<String> httpRequest = new HttpEntity<>(
                gson.toJson(new CreateTasksPost(
                        "user",
                        12573874
                )),
                httpRequestHeaderList);
        restTemplate.postForObject("https://api.teamgantt.com/v1/tasks/93164308/resources", httpRequest, CreateTasksPost.class);
    }

    public void getTasks(TasksController.PostRequest request) {
        final HttpHeaders httpRequestHeaderList = this.CreateHeaders(request);
        final Integer typeId = 12573874;

        final HttpEntity<String> httpRequest = new HttpEntity<>(httpRequestHeaderList);
        ResponseEntity<String> response = restTemplate.exchange(
                "https://api.teamgantt.com/v1/tasks", HttpMethod.GET, httpRequest, String.class);

        final Type collectionType = new TypeToken<List<TasksBody>>() {
        }.getType();
        final List<TasksBody> tasks = new Gson().fromJson(response.getBody(), collectionType);

        if (tasks != null) {
            final List<TasksBody> myTasks = tasks.stream()
                    .filter(it -> it.getResources().stream()
                            .map(TasksBody.resources::getType_id)
                            .filter(type_id -> type_id.equals(typeId))
                            .collect(Collectors.toList())
                            .contains(typeId)
                    )
                    .collect(Collectors.toList());

            System.out.println("");

        }

    }
}
