package com.stock.gateway.controllers;

import com.stock.gateway.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.stock.gateway.models.JwtRequest;
import com.stock.gateway.models.JwtResponse;
import com.stock.gateway.services.JwtService;
import com.stock.gateway.utils.JwtTokenUtil;


@RestController
@RequestMapping(path = "/user")
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtService jwtUserService;

	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getName(), authenticationRequest.getPassword());

		final UserDetails userDetails = jwtUserService.loadUserByUsername(authenticationRequest.getName());

		final String type = jwtUserService.getUserByName(authenticationRequest.getName()).getType();
		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token, type));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("User disabled", e);
		} catch (BadCredentialsException e) {
			throw new Exception("Invalid credentials", e);
		}
	}

	@PostMapping("/add")
	public void addUser(@RequestBody User user) {
		jwtUserService.addUser(user);
	}
}
