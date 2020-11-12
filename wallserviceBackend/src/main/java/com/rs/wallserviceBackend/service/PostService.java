package com.rs.wallserviceBackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rs.wallserviceBackend.converter.PostConverter;
import com.rs.wallserviceBackend.dto.NewPostDTO;
import com.rs.wallserviceBackend.model.Post;
import com.rs.wallserviceBackend.model.RegisteredUser;
import com.rs.wallserviceBackend.repository.PostRepository;

@Service
public class PostService {

	private PostRepository postRepository;
	private UserService userService;
	
	@Autowired
	public PostService(PostRepository postRepository, UserService userService) {
		this.postRepository = postRepository;
		this.userService = userService;
	}
	
	// Creates and initializes Post instance and saves it to database
	public Boolean createPost(NewPostDTO dto) {
		Post newPost = PostConverter.convertFromDto(dto);
		RegisteredUser loggedUser = userService.getLoggedUser();
		newPost.setUser(loggedUser);
		postRepository.save(newPost);
		return true;
	}
	

}
