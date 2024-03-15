package com.allabo.vo;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class PostVO {
	private int postSeq;
	private String tag;
	private String title;
	private String content;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	private int viewCount;
	private int fileSeq;
	private int utSeq;
	// 추가
	private int no;
	private String userId;
	private int teamSeq;
	private int role;
	private String nick;
	// join-조회수, 추천수 정보
	private int totalComments;
	private int totalLikes;

}
