package com.paul.SimpleBlog.service;

import com.paul.SimpleBlog.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepo repo;

    public List<Post> getPost(){
         return repo.findAll();
    }

//    public Optional<Post> getPostById(Long id){
//        return repo.findPostById(id);
//    }

    public void addPost(Post post1) {
        repo.save(post1);
    }

    public Optional<Post> getPostById(Long id) {
        return repo.findPostById(id);
    }
}
