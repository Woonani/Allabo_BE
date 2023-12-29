package com.allabo.dao;

import java.util.List;
import java.util.Map;

import com.allabo.vo.TeamAndMemberVO;
import com.allabo.vo.TeamVO;

public interface TeamDao {
		public int insertTeamAndGetTeamSeq(TeamAndMemberVO team);
		
		public TeamAndMemberVO selectOneTeam(int utSeq);
		
		public List<TeamAndMemberVO> selectTeamList (String userId);

		public int updateTeam(TeamVO teamVO);
		
		public int deleteTeam(int teamSeq);
		
}