package com.rs.wallserviceBackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rs.wallserviceBackend.converter.UserConverter;
import com.rs.wallserviceBackend.dto.LoginDTO;
import com.rs.wallserviceBackend.dto.TokenDTO;
import com.rs.wallserviceBackend.dto.UserDTO;
import com.rs.wallserviceBackend.model.RegisteredUser;
import com.rs.wallserviceBackend.model.User;
import com.rs.wallserviceBackend.repository.UserRepository;
import com.rs.wallserviceBackend.security.JwtToken;

@Service
public class AuthenticationService {

	private UserRepository userRepository;
	private AuthenticationManager authenticationManager;
	private JwtToken jwtTokenUtil;

	@Autowired
	public AuthenticationService(UserRepository userRepository, AuthenticationManager authenticationManager,
			JwtToken jwtTokenUtil) {
		this.userRepository = userRepository;
		this.authenticationManager = authenticationManager;
		this.jwtTokenUtil = jwtTokenUtil;
	}

	// Login: Checks if user exists, generates and returns jwt token
	public TokenDTO logIn(LoginDTO dto) {
		try {
			authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));
		} catch (BadCredentialsException | InternalAuthenticationServiceException e) {
			throw new UsernameNotFoundException(String.format("No user found with username '%s'.", dto.getUsername()));
		}
		final User user = userRepository.findOneByUsername(dto.getUsername());
		String token = jwtTokenUtil.generateToken(user.getUsername(), user.getRole().toString());
		return new TokenDTO(token);
	}

	// Registrations: Saves new user to the database 
	public UserDTO registrtion(UserDTO dto) {
		if (userRepository.findOneByUsername(dto.getUsername()) != null) {
			return null;
		}
		RegisteredUser newUser = UserConverter.convertFromDto(dto);
		userRepository.save(newUser);
		return dto;
	}

}
