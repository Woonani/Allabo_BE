package com.allabo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.allabo.dao.BoardDao;
import com.allabo.vo.PostVO;

@Service
public class BoardService {
	@Autowired
	private SqlSession sqlSession;
	
	@Transactional
	public PostVO addPost(PostVO data) {
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		boardDao.insertPostAndGetPostSeq(data);
		System.out.println("postVo data : " + data);
		PostVO post = boardDao.selectOnePost(data.getPostSeq());
		System.out.println("postVo post : " + post);
		return post;
	}
	
	@Transactional
	public Map<Object,Object> getPostList(int teamSeq, String tag, int noPerPage, int page, String searchTag, String searchWord){
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		int startPage = noPerPage*(page-1)+1;
		int endPage = noPerPage*page;

		Map<Object,Object> result = new HashMap<>();
		result.put("postlist", boardDao.selectPostList(teamSeq, tag, startPage, endPage, searchTag, searchWord ));
		result.put("totalPosts", boardDao.countBoardLength(teamSeq, tag, searchTag, searchWord ));
		return result;
	}
	
}
