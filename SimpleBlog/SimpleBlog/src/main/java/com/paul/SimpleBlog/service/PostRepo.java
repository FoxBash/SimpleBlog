package com.paul.SimpleBlog.service;

import com.paul.SimpleBlog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.util.Optional;

@Repository
public interface PostRepo extends JpaRepository<Post,Long> {

    Optional<Post> findPostById(Long id);
}
