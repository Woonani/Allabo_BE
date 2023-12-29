package com.allabo.dao;

import java.util.List;

import com.allabo.vo.TeamAndMemberVO;
import com.allabo.vo.UsersTeamVO;
import com.allabo.vo.UsersVO;

public interface MemberDao {
	public int insertMember(TeamAndMemberVO teamAndMember);

	public List<UsersVO> selectUserListById(String userId);
	
//	public int deleteUsersTeam(String userId, String teamId);
}
