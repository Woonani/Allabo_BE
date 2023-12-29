package com.allabo.dao;

import com.allabo.vo.TeamAndMemberVO;
import com.allabo.vo.UsersTeamVO;

public interface MemberDao {
	public int insertMember(TeamAndMemberVO teamAndMember);

	
//	public int deleteUsersTeam(String userId, String teamId);
}
