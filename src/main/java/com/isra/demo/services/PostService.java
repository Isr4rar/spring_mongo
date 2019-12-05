package com.isra.demo.services;

import com.isra.demo.domain.Post;
import com.isra.demo.domain.User;
import com.isra.demo.dto.UserDTO;
import com.isra.demo.repository.PostRepository;
import com.isra.demo.repository.UserRepository;
import com.isra.demo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Post post = repo.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Objeto não Encontrado"));
        return post;
    }

    public List<Post> findByTitle(String text) {
        return repo.findByTitleContainingIgnoreCase(text);
    }

}
