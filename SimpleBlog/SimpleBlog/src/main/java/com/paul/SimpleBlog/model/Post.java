package com.paul.SimpleBlog.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "post")
@Getter
@Setter
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title",nullable = false)
    private String title;
    @Column(name = "content",nullable = false)
    private String content;
    @Column(name = "time", updatable = false)
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    @NonNull
    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;


}
