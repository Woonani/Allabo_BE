package com.allabo.dao;

import java.util.List;

import com.allabo.vo.PostVO;

        
public interface BoardDao {
	
	public int insertPostAndGetPostSeq(PostVO post);
	
	public PostVO selectOnePost(int postSeq);
	
	public List<PostVO> selectPostList (int teamSeq, String tag, int noPerPage, int page, String searchTag, String searchWord  );

	public int countBoardLength (int teamSeq, String tag, String searchTag, String searchWord );

	// 입력된 검색어로 select
	public List<PostVO> selectPostListBySearch (int teamSeq, String searchTag, String searchWord); //, String tag, int noPerPage, int page );

	public int updatePost(PostVO post);
	
	public int updateViewCount(int postSeq);
		
	public int deletePost(int postSeq);
}
