package com.allabo.dao;

import java.util.List;
import java.util.Map;

import com.allabo.vo.TeamVO;

public interface TeamDao {
		public int insertTeam(TeamVO team);
		
		public List<TeamVO> selectTeamList (String userId);

		public TeamVO selectTeam (String teamId);
		
		public int updateTeam(TeamVO teamVO);
		
		public int deleteTeam(String teamId);
}