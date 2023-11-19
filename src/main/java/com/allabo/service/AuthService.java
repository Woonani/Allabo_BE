package com.allabo.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allabo.dao.AuthDao;
import com.allabo.vo.UsersVO;

@Service
public class AuthService {
	@Autowired
	private SqlSession sqlSession; //ibatis 있어야 함
	
	public int signup(UsersVO usersVO) {
		AuthDao dao = sqlSession.getMapper(AuthDao.class);
		return dao.signup(usersVO);
	}
}
