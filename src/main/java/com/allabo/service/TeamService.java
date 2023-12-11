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
	
	public int addTeam(Map<String, String> data) {
		TeamDao dao = sqlSession.getMapper(TeamDao.class);
		return dao.insertTeam(data);
	}
	
	public List<TeamVO> getTeam(String userId) {
		TeamDao dao = sqlSession.getMapper(TeamDao.class);
		return dao.selectTeamList(userId);
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