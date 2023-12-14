package com.allabo.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allabo.dao.TeamDao;
import com.allabo.vo.TeamVO;

@Service
public class TeamService {
	@Autowired
	private SqlSession sqlSession;
	
	public int addTeam(TeamVO team) {
		TeamDao dao = sqlSession.getMapper(TeamDao.class);
		return dao.insertTeam(team);
	}
	
	public List<TeamVO> getTeamList(String userId) {
		TeamDao dao = sqlSession.getMapper(TeamDao.class);
		return dao.selectTeamList(userId);
	}
	
	public TeamVO getTeam(String teamId) {
		TeamDao dao = sqlSession.getMapper(TeamDao.class);
		return dao.selectTeam(teamId);
	}
	
	public int modifyTeam(TeamVO teamVO) {
		TeamDao dao = sqlSession.getMapper(TeamDao.class);
		return dao.updateTeam(teamVO);
	}
	
	public int deleteTeam(String teamId) {
		TeamDao dao = sqlSession.getMapper(TeamDao.class);
		return dao.deleteTeam(teamId);
	}
	
}