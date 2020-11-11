package com.rs.wallserviceBackend.service;

import org.springframework.stereotype.Service;

import com.rs.wallserviceBackend.repository.CommentRepository;

@Service
public class CommentService {

	private CommentRepository commentRepository;
	
	public CommentService( CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}
}
