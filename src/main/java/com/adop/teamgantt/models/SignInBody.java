package com.adop.teamgantt.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignInBody {

    private final Integer user_id;
    private final String api_key;
    private final String user_token;
    private final String expires;

}


