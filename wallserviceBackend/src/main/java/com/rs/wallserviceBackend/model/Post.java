package com.rs.wallserviceBackend.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Post {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne
	private RegisteredUser user;
	
	@Column
	private LocalDateTime creationDate;
	
	@Column
	private String text;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Review>  reviews;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Comment> comments;
	
	public Post() {
		this.reviews = new HashSet<Review>();
		this.comments = new HashSet<Comment>();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public RegisteredUser getUser() {
		return user;
	}

	public void setUser(RegisteredUser user) {
		this.user = user;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Set<Review> getReviews() {
		return reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	
	

}
