package com.allabo.dao;

import java.util.List;

import com.allabo.vo.CommentVO;

public interface CommentDao {
	public int insertCommentAndGetSeq(CommentVO commentVO);
	
	public List<CommentVO> selectCommentList(int teamSeq, int postSeq );
	
	public CommentVO selectOneComment(int cmmntSeq );
	
	public int deleteComment(int cmmntSeq);
}