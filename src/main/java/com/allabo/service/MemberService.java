package com.allabo.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.allabo.dao.MemberDao;
import com.allabo.vo.TeamAndMemberVO;
import com.allabo.vo.UsersTeamVO;
import com.allabo.vo.UsersVO;

@Service
public class MemberService {

	@Autowired
	private SqlSession sqlSession;

	@Transactional
	public int inviteMembers(int teamSeq, List<String> userIds) {
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		int result = 0;

		for(String userId : userIds) {
			System.out.println(userId);
			TeamAndMemberVO member = new UsersTeamVO();
			member.setTeamSeq(teamSeq);
			member.setRole(2);
			member.setUserId(userId);
			member.setNick(userId); // 처음 초대 시 default nick은 user 아이디 // 또는 랜덤생성 할까?
			System.out.println("확인 : " + member);
			result += dao.insertMember(member);
		}
		return result; // 진호 : 여기 응답을 뭐라고 해야함?
	}
	
	public List<UsersVO> searchUserList(String userId){
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		return dao.selectUserListById(userId);
	}
	
	public List<TeamAndMemberVO> getMemberList(int teamSeq){
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		return dao.selectMemberListById(teamSeq);
//		return null;
	}
	
}
