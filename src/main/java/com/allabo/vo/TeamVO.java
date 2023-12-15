package com.allabo.vo;

import lombok.Data;

@Data
public class TeamVO {
	private int teamId; //team_seq;
	private String teamName; //team_name;
	private String createdAt; //created_at;
	private String description;
	// join문으로 teamList를 불러올 때 필요한 변수들.
	private String userid;
	private String role;
	private String nick;
	
}