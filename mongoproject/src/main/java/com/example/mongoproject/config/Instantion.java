package com.example.mongoproject.config;


import com.example.mongoproject.domain.Post;
import com.example.mongoproject.domain.User;
import com.example.mongoproject.dto.AuthorDto;
import com.example.mongoproject.dto.CommentDto;
import com.example.mongoproject.repository.PostRepository;
import com.example.mongoproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@Configuration
public class Instantion implements CommandLineRunner {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");



    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();


        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User stephan = new User(null, "Stephan Guimaraes", "stephan.guimaraess@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, stephan, bob));

        Post post1 = new Post(null, sdf.parse("21/03/2018"),"Partiu viagem!","Vou viajar para são paulo, abraços!",new AuthorDto(stephan));
        Post post2 = new Post(null, sdf.parse("21/03/2019"),"Partiu viagems!","Vou viajar para rio de janeiro, abraços!",new AuthorDto(stephan));

        CommentDto c1 = new CommentDto("Boa viagem mano.",sdf.parse("13/02/2018"),new AuthorDto(bob));
        CommentDto c2 = new CommentDto("Boa viagem cara.",sdf.parse("11/02/2018"),new AuthorDto(maria));

        post1.getComments().addAll(Arrays.asList(c1,c2));

        postRepository.save(post1);

        postRepository.saveAll(Arrays.asList(post1, post2));
        stephan.getPosts().addAll(Arrays.asList(post1,post2));

        userRepository.save(stephan);



    }
}
