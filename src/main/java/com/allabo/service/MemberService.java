package com.allabo.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allabo.dao.MemberDao;
import com.allabo.vo.UsersVO;

@Service
public class MemberService {

	@Autowired
	private SqlSession sqlSession;
	
	public List<UsersVO> searchUserList(String userId){
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		return dao.selectUserListById(userId);
	}
}
