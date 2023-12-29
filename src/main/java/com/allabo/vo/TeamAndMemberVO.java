package com.allabo.vo;

import lombok.Data;

@Data
public class TeamAndMemberVO {
	private int teamSeq; //team_seq;
	private String teamName; //team_name;
	private String createdAt; //created_at;
	private String description;
	// join문으로 teamList를 불러올 때 필요한 변수들.
	private int utSeq; //ut_seq
	private String userId; //user_id
	private int role;
	private String nick;
	
}