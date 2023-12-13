package com.allabo.utils;

import java.util.Date;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtUtil {
	
	public static String generateToken(String email) {
		SecretKey key = Keys.hmacShaKeyFor(JwtProperties.getSecretKey());
		// JwtProperties 동일한 패키지 내의 class는 import 없이 사용가능, getSecretKey()는 static 매서드
		return Jwts.builder()
                .setSubject(email)
                .setExpiration(new Date(System.currentTimeMillis() + JwtProperties.EXPIRATION_TIME))  
                .signWith(key)  // .signWith(SignatureAlgorithm.HS256, SECRET_KEY)  
                //JWT 라이브러리에서는 암호화 알고리즘을 지정하지 않으면 기본적으로 HMACSHA256을 사용
                .compact();
	}
}
