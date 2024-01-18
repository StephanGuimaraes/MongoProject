package com.example.mongoproject.dto;
import com.example.mongoproject.domain.User;
import org.springframework.data.annotation.Id;

import java.io.Serializable;


public class UserDto implements Serializable {

    @Id
    private String id;
    private String name;
    private String email;

    public UserDto(){}

    public UserDto(User obj){

        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
