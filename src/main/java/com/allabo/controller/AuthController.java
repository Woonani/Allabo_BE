package com.allabo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allabo.service.AuthService;
import com.allabo.vo.UsersVO;

@RestController 
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	private AuthService authService;
	
	@PostMapping("/signup")
	public ResponseEntity<?> signup(@RequestBody UsersVO usersVO) {
		System.out.println(usersVO);
		int result = authService.signup(usersVO);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UsersVO usersVO) {
		System.out.println(usersVO);
		int result = authService.login(usersVO);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("/test")
	public ResponseEntity<?> test() {
		System.out.println("test");
		return new ResponseEntity<>("", HttpStatus.OK);
	}	
}
