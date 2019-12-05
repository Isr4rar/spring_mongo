package com.isra.demo.config;

import com.github.javafaker.Faker;
import com.isra.demo.domain.Post;
import com.isra.demo.domain.User;
import com.isra.demo.dto.AuthorDTO;
import com.isra.demo.dto.CommentDTO;
import com.isra.demo.repository.PostRepository;
import com.isra.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Date;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    private Faker faker = new Faker();

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        postRepository.deleteAll();

        User user1 = new User(null, faker.name().firstName(),faker.internet().emailAddress(),faker.number().digits(11));
        User user2 = new User(null, faker.name().firstName(),faker.internet().emailAddress(),faker.number().digits(11));
        User user3 = new User(null, faker.name().firstName(),faker.internet().emailAddress(),faker.number().digits(11));
        User user4 = new User(null, faker.name().firstName(),faker.internet().emailAddress(),faker.number().digits(11));

        userRepository.saveAll(Arrays.asList(user1,user2,user3,user4));

        Post post1 = new Post(null, faker.date().birthday(22,23), faker.leagueOfLegends().masteries(), faker.lorem().paragraph(), new AuthorDTO(user1));
        Post post2 = new Post(null, faker.date().birthday(22,23), faker.leagueOfLegends().masteries(), faker.lorem().paragraph(), new AuthorDTO(user3));
        Post post3 = new Post(null, faker.date().birthday(22,23), faker.leagueOfLegends().masteries(), faker.lorem().paragraph(), new AuthorDTO(user1));
        Post post4 = new Post(null, faker.date().birthday(22,23), faker.leagueOfLegends().masteries(), faker.lorem().paragraph(), new AuthorDTO(user3));

        CommentDTO c1 = new CommentDTO(faker.lorem().paragraph(), faker.date().birthday(22,23), new AuthorDTO(user2));
        CommentDTO c2 = new CommentDTO(faker.lorem().paragraph(), faker.date().birthday(22,23), new AuthorDTO(user4));
        CommentDTO c3 = new CommentDTO(faker.lorem().paragraph(), faker.date().birthday(22,23), new AuthorDTO(user2));
        CommentDTO c4 = new CommentDTO(faker.lorem().paragraph(), faker.date().birthday(22,23), new AuthorDTO(user4));

        post1.getComments().addAll(Arrays.asList(c1,c3));
        post2.getComments().addAll(Arrays.asList(c2,c4));

        postRepository.saveAll(Arrays.asList(post1, post2, post3, post4));

        user1.getPosts().addAll(Arrays.asList(post1, post3));
        user3.getPosts().addAll(Arrays.asList(post2, post4));

        userRepository.saveAll(Arrays.asList(user1,user3));

    }
}
