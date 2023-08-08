package com.example.spring.repositories;

import com.example.spring.models.Post;
import com.example.spring.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post findByTitle(String title);
}
