package com.example.mongoproject.services;

import com.example.mongoproject.domain.Post;
import com.example.mongoproject.domain.User;
import com.example.mongoproject.repository.PostRepository;
import com.example.mongoproject.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
public class PostService {


    @Autowired
    PostRepository postRepository;

    public Post findById(String id) {
        Optional<Post> post = postRepository.findById(id);
        if(post == null){
            throw new ObjectNotFoundException("User not found!");
        }
        return post.orElseThrow(() -> new ObjectNotFoundException(id));
    }

    public List<Post> findByTitle(String text){
        return postRepository.findByTitleContainingIgnoreCase(text);
    }
}
