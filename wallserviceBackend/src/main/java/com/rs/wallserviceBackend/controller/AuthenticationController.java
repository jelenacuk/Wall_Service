package com.rs.wallserviceBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.wallserviceBackend.dto.LoginDTO;
import com.rs.wallserviceBackend.dto.TokenDTO;
import com.rs.wallserviceBackend.dto.UserDTO;
import com.rs.wallserviceBackend.service.AuthenticationService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthenticationController {

	private AuthenticationService authService;
	
	@Autowired
	public AuthenticationController(AuthenticationService authService) {
		this.authService = authService;
	}
	
	@PostMapping(value = "/login")
	public ResponseEntity<TokenDTO> login(@RequestBody LoginDTO dto) {
		TokenDTO token = this.authService.logIn(dto);
		return new ResponseEntity<TokenDTO>(token, HttpStatus.OK);
	}
	
	@PostMapping(value = "/registration")
	public ResponseEntity<UserDTO> register(@RequestBody UserDTO dto) {
		UserDTO user = this.authService.registrtion(dto);
		return new ResponseEntity<UserDTO>(user, HttpStatus.OK);
	}
}
