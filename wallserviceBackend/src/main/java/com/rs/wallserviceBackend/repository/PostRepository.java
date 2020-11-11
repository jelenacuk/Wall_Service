package com.rs.wallserviceBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.wallserviceBackend.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
