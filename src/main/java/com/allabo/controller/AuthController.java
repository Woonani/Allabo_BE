package com.allabo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allabo.service.AuthService;
import com.allabo.utils.JwtUtil;
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
		if(result == 1) {
			//토큰 발급
			String token = JwtUtil.generateToken(usersVO.getUserId());
			System.out.println("token : " + token);
			
			UsersVO loginuser = authService.getLoginUserInfo(usersVO.getUserId());
			Map<String, Object> data = new HashMap<>();
			data.put("token", token);
			data.put("loginuser", loginuser);
//			data.put("팀리스트?", data);

			return new ResponseEntity<>(data, HttpStatus.OK);
		}else if(result == 0){
			//로그인 실패
			return new ResponseEntity<>(1, HttpStatus.OK);
		}else {
			// 에러 
			return new ResponseEntity<>(1, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/test")
	public ResponseEntity<?> test() {
		System.out.println("test");
		return new ResponseEntity<>("", HttpStatus.OK);
	}	
}
