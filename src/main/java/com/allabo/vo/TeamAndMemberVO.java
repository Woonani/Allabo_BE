package com.allabo.vo;

import java.util.List;

import lombok.Data;

@Data
public class TeamAndMemberVO {
	private int teamSeq; //team_seq;
	private String teamName; //team_name;
	private String createdAt; //created_at;
	private String description;
	// join문으로 teamList, memberList를 불러올 때 필요한 변수들.
	private int utSeq; //ut_seq
	private String userId; //user_id
	private int role;
	private String nick;
	private String profileSrc; //profile_src
	private String visible;
	// 멤버리스트
	private List<String> invitees;
}