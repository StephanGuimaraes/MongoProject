package com.example.mongoproject.dto;

import com.example.mongoproject.domain.User;

import java.io.Serializable;

public class AuthorDto implements Serializable {

    private String id;
    private String name;

    public AuthorDto(){}

    public AuthorDto(User user){
        this.id = user.getId();
        this.name = user.getName();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
