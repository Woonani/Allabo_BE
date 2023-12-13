package com.allabo.utils;

import java.util.Base64;

public interface JwtProperties { 
	String SECRET = "hopetobedeveloperpleasegotmywishGOD";
	
	int EXPIRATION_TIME = 1000*60*60*24*2; //2일 // static 변수도 아닌데 꺼내 쓸 수 있다공?.?
	// 아래 코드들은 왜 ... ?여기다가?
	String TOKEN_PREFIX = "Bearer ";
	String HEADER_STRING = "Authorization";
	
	//SECRET 값을 Base64로 인코딩한 바이트 배열을 반환하는 역할
	public static byte[] getSecretKey() {
		try {
			return Base64.getEncoder().encode(SECRET.getBytes("UTF-8"));
		} catch (Exception e) {
			e.printStackTrace(); // ?
			System.out.println(e.getLocalizedMessage());
		}
		return null;
	}
}
