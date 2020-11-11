package com.rs.wallserviceBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.rs.wallserviceBackend.service.PostService;

@RestController
public class PostController {
 
	private PostService postService;
	
	@Autowired
	public PostController(PostService postService) {
		this.postService = postService;
	}
}
