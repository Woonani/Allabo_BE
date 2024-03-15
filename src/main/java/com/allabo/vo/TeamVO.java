package com.allabo.vo;

import lombok.Data;

@Data
public class TeamVO {
	private int teamSeq; //team_seq;
	private String teamName; //team_name;
	private String createdAt; //created_at;
	private String description;
	// join문으로 teamList를 불러올 때 필요한 변수들 >> TeamAndMemberVO 이용
//	private String userId; //user_id
//	private String role;
//	private String nick;
	
}