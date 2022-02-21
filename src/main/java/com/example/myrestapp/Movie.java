package com.example.myrestapp;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class Movie {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String id;
    private String name;
    private String director;
}
