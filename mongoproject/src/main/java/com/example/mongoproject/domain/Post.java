package com.example.mongoproject.domain;
import com.example.mongoproject.dto.AuthorDto;
import com.example.mongoproject.dto.CommentDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Document
public class Post implements Serializable {

    @Id
    private String id;
    private Date data;
    private String title;
    private String body;
    private AuthorDto author;

    private List<CommentDto> comments = new ArrayList<>();


    public Post(){}

    public Post(String id, Date data, String title, String body, AuthorDto author) {
        this.id = id;
        this.data = data;
        this.title = title;
        this.body = body;
        this.author = author;

    }

    public String getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public AuthorDto getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDto author) {
        this.author = author;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<CommentDto> getComments() {
        return comments;
    }

    public void setComments(List<CommentDto> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
