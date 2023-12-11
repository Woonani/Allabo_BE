package com.allabo.dao;

import java.util.List;
import java.util.Map;

import com.allabo.vo.TeamVO;

public interface TeamDao {
		public int insertTeam(Map<String, String> data);
		
		public List<TeamVO> selectTeamList (String userId);
		
		public int updateTeam(TeamVO teamVO);
		
		public int deleteTeam(String teamId);
}