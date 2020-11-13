package com.rs.wallserviceBackend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rs.wallserviceBackend.converter.PostConverter;
import com.rs.wallserviceBackend.dto.NewPostDTO;
import com.rs.wallserviceBackend.dto.PostDTO;
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
	
	// Returns posts for one page
	public List<PostDTO> getPosts(Pageable pageable){
		Page<Post> posts = postRepository.findAllByOrderByCreationDateDesc(pageable);
		return (posts.stream().map(post -> {
			PostDTO dto = PostConverter.convertFromDto(post);
			dto.setSize(posts.getTotalElements());
			return dto;
		})).collect(Collectors.toList());
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
