package com.allabo.dao;

import com.allabo.vo.LikesVO;

public interface LikesDao {
	public int insertLike(LikesVO like);
	
	public LikesVO selectUserAndcountLikes(String userId, int postSeq);
	
	public int deleteLike(LikesVO like);
}
