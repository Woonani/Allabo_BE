package com.allabo.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.allabo.dao.MemberDao;
import com.allabo.dao.TeamDao;
import com.allabo.vo.TeamAndMemberVO;
import com.allabo.vo.TeamVO;
import com.allabo.vo.UsersTeamVO;

@Service
public class TeamService {
	@Autowired
	private SqlSession sqlSession;
	
	@Transactional
	public TeamAndMemberVO addTeam(TeamAndMemberVO data) {
//		1. 팀정보 insert
		TeamDao teamDao = sqlSession.getMapper(TeamDao.class);
		teamDao.insertTeamAndGetTeamSeq(data);
		System.out.println("t insert 후 team_seq 확인 : " + data);

	    //2. 호스트정보 setting, insert
		data.setRole(1);
		
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
		memberDao.insertMember(data);
		System.out.println("ut insert 후 ut_seq 확인 : " + data);
		
		//3. insert한 Team, Member정보 TeamAndMemberVO로 반환
		// 그런데 1~2 과정 성공후 [원본 그대로 반환] vs [insert한 값 db에서 꺼내오기]
		TeamAndMemberVO teamAndMember = teamDao.selectOneTeam(data.getUtSeq());
	    System.out.println("가져온 한팀의 정보" + teamAndMember);

	    return teamAndMember;
	}
	
	public List<TeamAndMemberVO> getTeamList(String userId) {
		TeamDao dao = sqlSession.getMapper(TeamDao.class);
		return dao.selectTeamList(userId);
	}
	
	@Transactional
	public TeamAndMemberVO modifyTeam(int utSeq, TeamVO data) {
		TeamDao dao = sqlSession.getMapper(TeamDao.class);
		int rslt1 = dao.updateTeam(data);
		TeamAndMemberVO rslt2 = dao.selectOneTeam(utSeq);
		return rslt2;
	}
	
	public int removeTeam(int teamSeq) {
		TeamDao dao = sqlSession.getMapper(TeamDao.class);
		return dao.deleteTeam(teamSeq);
	}
	
}