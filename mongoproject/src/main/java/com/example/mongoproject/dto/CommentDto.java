package com.example.mongoproject.dto;

import java.io.Serializable;
import java.util.Date;

public class CommentDto implements Serializable {

    private String text;
    private Date data;
    private AuthorDto authorDto;


    public CommentDto(){}

    public CommentDto(String text, Date data, AuthorDto authorDto) {
        this.text = text;
        this.data = data;
        this.authorDto = authorDto;
    }

    public String getText() {
        return text;
    }

    public Date getData() {
        return data;
    }

    public AuthorDto getAuthorDto() {
        return authorDto;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setAuthorDto(AuthorDto authorDto) {
        this.authorDto = authorDto;
    }


}
