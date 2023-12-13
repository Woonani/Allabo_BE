package com.allabo.vo;

import lombok.Data;

@Data
public class UsersVO {
//	private String userId; // user_seq;
	private String email;
	private String password; 
	private String name; // user_name
	private String companyName; //company
	private String createdAt; //created_at;
	private String profile;// profile_src회원정보페이지
	private String visible;
}
