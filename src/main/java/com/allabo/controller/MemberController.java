package com.allabo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allabo.service.MemberService;
import com.allabo.vo.UsersVO;

@RestController
@RequestMapping("/api/member")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/search/{userId}")
	public ResponseEntity<?> getSearchList(@PathVariable String userId){
		List<UsersVO> data = new ArrayList<>();
		data = memberService.searchUserList(userId);
		return new ResponseEntity<>(data, HttpStatus.OK);
	}
}
