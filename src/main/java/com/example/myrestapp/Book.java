package com.example.myrestapp;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Book {
    private String id;
    private String name;
    private String author;
}
