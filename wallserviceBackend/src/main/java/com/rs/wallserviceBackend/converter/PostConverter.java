package com.rs.wallserviceBackend.converter;

import com.rs.wallserviceBackend.dto.NewPostDTO;
import com.rs.wallserviceBackend.model.Post;

public class PostConverter {

	public static Post convertFromDto(NewPostDTO dto) {
		Post newPost = new Post();
		newPost.setText(dto.getText());
		newPost.setCreationDate(dto.getCreationDate());
		return newPost;
	}
}
