package com.allabo.dao;

import com.allabo.vo.UsersTeamVO;

public interface UsersTeamDao {
	public int insertUsersTeam(UsersTeamVO usersTeam);
	
	public int deleteUsersTeam(String userId, String teamId);
}
