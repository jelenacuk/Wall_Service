package com.rs.wallserviceBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.wallserviceBackend.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public User findOneByUsername(String username);
}
