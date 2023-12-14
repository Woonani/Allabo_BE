package com.allabo.service;

import java.util.HashMap;

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
	
	public int login(UsersVO usersVO) {
		AuthDao dao = sqlSession.getMapper(AuthDao.class);
		return dao.login(usersVO);
	}
	
	public UsersVO getLoginUserInfo(String userid) {
		AuthDao dao = sqlSession.getMapper(AuthDao.class);
		HashMap<String, String> data = dao.loginUser(userid);
		System.out.println(data);
		UsersVO userInfo  = new UsersVO();
		userInfo.setCompanyName(data.get("company"));
//		userInfo.setCreatedAt(data.get("created_at"));
		userInfo.setUserid(data.get("userid"));
		userInfo.setPassword(data.get("password"));
		userInfo.setProfile(data.get("profile_src"));
		userInfo.setName(data.get("user_name"));
//		userInfo.setUserId(data.get("user_seq"));
//		userInfo.setVisible(data.get("visible"));

		return userInfo;
	}
}
