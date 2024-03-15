package com.allabo.vo;

import java.sql.Timestamp;
import lombok.Data;

@Data
public class CommentVO {
	private int cmmntSeq; // cmmnt_seq
	private String comment;
	private Timestamp createdAt;
	private String userId;
	private int postSeq;
	private int replySeq; //reply_seq
	
	//ut테이블 join
	private int role; //
	private String nick; //
	// 대댓글 구분
	private int replyNick;
	
	

}
