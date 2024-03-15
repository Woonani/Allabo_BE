package com.allabo.vo;

import lombok.Data;

@Data
public class UsersTeamVO extends TeamAndMemberVO {
	private String userId; // user_id
	private int teamSeq; //team_seq;
	private int role; //team_seq;
	private String nick;

}
