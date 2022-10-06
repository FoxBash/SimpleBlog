package com.paul.SimpleBlog.controller;

import com.paul.SimpleBlog.model.Post;
import com.paul.SimpleBlog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Optional;

@Controller
public class homeController {
    @Autowired
    private PostService postService;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("post", postService.getPost());
        return "index";
    }
    @GetMapping("/home")
    public String index(Model model){
        model.addAttribute("post", postService.getPost());
        return "index";
    }

    @GetMapping("/addPost")
    public String addPost(Model model){
        model.addAttribute("post", new Post());
        return "addPost";

    }
    @GetMapping("/viewStory/{id}")
    public String view(@PathVariable("id") Long id, Model model){
        Optional<Post> post = postService.getPostById(id);
        if (post.isPresent()){
            Post post1 = post.get();
            model.addAttribute("post",post1);
            return "viewStory";
        }
        else {
            return "error";
        }

    }
    @PostMapping("/save")
    public String savaPost(@ModelAttribute Post post){
        post.setCreatedAt(LocalDateTime.now());
        postService.addPost(post);
        return "redirect:/";
    }


}
