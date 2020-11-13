package com.rs.wallserviceBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.wallserviceBackend.dto.NewPostDTO;
import com.rs.wallserviceBackend.dto.PostDTO;
import com.rs.wallserviceBackend.service.PostService;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin
public class PostController {
 
	private PostService postService;
	
	@Autowired
	public PostController(PostService postService) {
		this.postService = postService;
	}
	
	@GetMapping
	public ResponseEntity<List<PostDTO>> getPosts(Pageable pageable) {
		List<PostDTO> result = postService.getPosts(pageable);
		return new ResponseEntity<List<PostDTO>>(result, HttpStatus.OK);
	}
	
	@PostMapping(value = "/create")
	@PreAuthorize("hasAuthority('ROLE_REGISTERED')")
	public ResponseEntity<Boolean> createPost(@RequestBody NewPostDTO dto) {
		Boolean result = postService.createPost(dto);
		return new ResponseEntity<Boolean>(result, HttpStatus.OK);
	}
}
