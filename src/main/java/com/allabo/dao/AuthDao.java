package com.allabo.dao;

import com.allabo.vo.UsersVO;

public interface AuthDao {
	public int signup(UsersVO usersVO);

	public int login(UsersVO usersVO);
}
