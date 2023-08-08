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
//		List<Post> posts = postDao.findAll();
		model.addAttribute("posts", postDao.findAll());
		return "posts/index";
	}
	
	
	//View individual post
	@GetMapping("/posts/{id}")
	public String viewIndividualPost(@PathVariable long id, Model model) {
		Post post = postDao.findById(id).orElse(null);
		model.addAttribute("post", post);
		return "posts/show";
	}
	
	//Create a new post
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
	
	//Edit a post
	@GetMapping("/posts/{id}/edit")
	public String viewFormEditPost(@PathVariable Long id, Model model) {
		Post post = postDao.findById(id).orElse(null);
		model.addAttribute("post", post);
		return "posts/edit";
	}
	
	@PostMapping("/posts/{id}/edit")
	public String editPost(@PathVariable Long id, @ModelAttribute Post updatedPost) {
		Post existingPost = postDao.findById(id).orElse(null);
		if (existingPost != null) {
			existingPost.setTitle(updatedPost.getTitle());
			existingPost.setBody(updatedPost.getBody());
			postDao.save(existingPost);
		}
		return "redirect:/posts/" + id;
	}
	
	
	//create Delete a post
	@PostMapping("/posts/{id}/delete")
	public String deletePost(@PathVariable Long id) {
		postDao.deleteById(id);
		return "redirect:/posts";
	}
	
	
}
