package com.example.spring.controllers;

import com.example.spring.models.Post;
import com.example.spring.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/*
Exercise 3

Create a PostController class.
This controller should return strings for the following routes that describe what will ultimately be
there.

method	url	description
GET	/posts	posts index page
GET	/posts/{id}	view an individual post
GET	/posts/create	view the form for creating a post
POST	/posts/create	create a new post

 */
@Controller
public class PostController {
	
	private final PostRepository postDao;
	
	public PostController(PostRepository postRepository) {
		this.postDao = postRepository;
	}
	
	
	@GetMapping("/posts")
	public String viewPostIndexPage(Model model) {
		model.addAttribute("posts", postDao.findAll());
		return "posts/index";
	}
	
	@GetMapping("/posts/{id}")
	@ResponseBody
	public String viewIndividualPost(@PathVariable int id) {
		return "Viewing post with ID: " + id;
	}
	
	@GetMapping("/posts/create")
	public String viewFormCreatePost(Model model) {
		model.addAttribute("post", new Post());
		return "/posts/create";
	}
	
	@PostMapping("/posts/create")
	public String createNewPost(@ModelAttribute Post newPost) {
		postDao.save(newPost);
		return "redirect:/posts";
	}

}
