package com.adop.teamgantt.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateSignIn {
    private final String user;
    private final String pass;
}
