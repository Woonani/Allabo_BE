package com.allabo.vo;

import lombok.Data;

@Data
public class LikesVO {
	private int likeSeq; //like_seq
	private String userId; //user_id
//	private int utSeq; //ut_seq
	private int postSeq; //post_seq
 
	// 좋아요 정보
	private int totalLikes;
	private int userLike;
}
