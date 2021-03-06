package com.rs.wallserviceBackend.converter;

import com.rs.wallserviceBackend.dto.NewPostDTO;
import com.rs.wallserviceBackend.dto.PostDTO;
import com.rs.wallserviceBackend.model.Post;

public class PostConverter {

	public static Post convertFromDto(NewPostDTO dto) {
		Post newPost = new Post();
		newPost.setText(dto.getText());
		newPost.setCreationDate(dto.getCreationDate());
		return newPost;
	}
	
	public static PostDTO convertFromDto(Post post) {
		PostDTO dto = new PostDTO();
		dto.setUsername(post.getUser().getUsername());
		dto.setCreationDate(post.getCreationDate());
		//rating
		dto.setText(post.getText());
		return dto;
	}
}
