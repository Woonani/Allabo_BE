package com.allabo.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allabo.dao.UsersTeamDao;
import com.allabo.vo.UsersTeamVO;

@Service
public class UsersTeamService {
	@Autowired
	private SqlSession sqlSession;
	
	public int addUsersTeam(UsersTeamVO usersTeam) {
		UsersTeamDao dao = sqlSession.getMapper(UsersTeamDao.class);
		return dao.insertUsersTeam(usersTeam);
	}
	
	
}
