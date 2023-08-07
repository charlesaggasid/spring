package com.example.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

	@GetMapping("/posts")
	@ResponseBody
	public String index() {
		return "Posts index page";
	}
	
	@GetMapping("/posts/{id}")
	@ResponseBody
	public String viewIndividualPost(@PathVariable int id) {
		return "Viewing post with ID: " + id;
	}
	
	@GetMapping("/posts/create")
	@ResponseBody
	public String viewFormCreatePost() {
		return "Viewing form for creating a post";
	}
	
	@PostMapping("/posts/create")
	@ResponseBody
	public String createNewPost(@ModelAttribute Post post) {
		// Logic to save the new post
		return "New post created";
	}

}
