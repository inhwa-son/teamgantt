package com.adop.teamgantt.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateTasksPost {

    @JsonProperty("type")
    private final String type;

    @JsonProperty("type_id")
    private final Integer type_id;

}
