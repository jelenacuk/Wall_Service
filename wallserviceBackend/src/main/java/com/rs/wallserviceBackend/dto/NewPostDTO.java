package com.rs.wallserviceBackend.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

public class NewPostDTO {

	@NotNull
	private String text;
	@NotNull
	private LocalDateTime creationDate;
	
	public NewPostDTO() {
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	

	
	
	
}
