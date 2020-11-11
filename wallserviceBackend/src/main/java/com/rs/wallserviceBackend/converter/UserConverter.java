package com.rs.wallserviceBackend.converter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.rs.wallserviceBackend.dto.UserDTO;
import com.rs.wallserviceBackend.model.RegisteredUser;
import com.rs.wallserviceBackend.model.Role;

public class UserConverter {

	private static BCryptPasswordEncoder bc = new BCryptPasswordEncoder(); 
	
	public static RegisteredUser convertFromDto(UserDTO dto) {
		RegisteredUser user = new RegisteredUser();
		user.setUsername(dto.getUsername());
		user.setPassword(bc.encode(dto.getPassword()));
		user.setFirstName(dto.getFirstName());
		user.setLastName(dto.getLastName());
		user.setEmail(dto.getEmail());
		user.setRole(Role.ROLE_REGISTERED);
		return user;
	}
}
