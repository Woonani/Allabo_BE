package com.allabo.dao;

import java.util.HashMap;

import com.allabo.vo.UsersVO;

public interface AuthDao {
	public int signup(UsersVO usersVO);

	public int login(UsersVO usersVO);
	
	public HashMap<String, String> loginUser(String email);
	
}
