package com.allabo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/member")
public class MemberController {
	
	@GetMapping("/search/{userId}")
	public ResponseEntity<?> getSearchList(@PathVariable String userId){
		
		return null;
	}
}
