package com.example.jobPortal.payload.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class UserCreateDto {
    private String username;

    private String password;

    private String name;

    private List<String> skills;

    private String phoneNumber;

    private List<String> education;

    private List<String> experiences;
}
