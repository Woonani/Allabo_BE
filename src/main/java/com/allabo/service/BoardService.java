package com.allabo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.allabo.dao.BoardDao;
import com.allabo.dao.CommentDao;
import com.allabo.dao.LikesDao;
import com.allabo.vo.CommentVO;
import com.allabo.vo.LikesVO;
import com.allabo.vo.PostVO;

@Service
public class BoardService {
	@Autowired
	private SqlSession sqlSession;
	
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
	
	@Transactional
	public Map<Object,Object> getPost(int postSeq, String userId){
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		CommentDao commentDao = sqlSession.getMapper(CommentDao.class);
		LikesDao likesDao = sqlSession.getMapper(LikesDao.class);
		
		Map<Object, Object> result = new HashMap<>();
		
		// 글 정보 불러오기
		PostVO post = boardDao.selectOnePost(postSeq);
		// 댓글 정보 불러오기
		List<CommentVO> commentlist = commentDao.selectCommentList(post.getTeamSeq(), postSeq);
		// 좋아요 정보 담기
		LikesVO likes= likesDao.selectUserAndcountLikes(userId, postSeq );
		
		result.put("post", post);
		result.put("commentlist", commentlist);
		result.put("totalComments", commentlist.size()); // 댓글 수
		result.put("totalLikes", likes.getTotalLikes());// 좋아요 수
		result.put("userLike", likes.getUserLike());// 로그인 유저의 좋아요 여부 1:true/0:false
//		System.out.println("likes확인 - "+likes);
		
//		result.put("likeOrNot", boardDao.selectPostLike(postSeq, userId));
		
		return result;
	}
	
	@Transactional
	public PostVO getPostEdit(int postSeq){
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		// 수정할 글 정보 불러오기
		return boardDao.selectOnePost(postSeq);
	}
	
	@Transactional
	public int setPostEdit(PostVO post){
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		// 글 정보 수정하기
		return boardDao.updatePost(post);
	}

	@Transactional
	public int addViewCount(int postSeq) {
		// 클릭시 조회수 컬럼 반영(게시물 컬럼 update)
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		int result = boardDao.updateViewCount(postSeq);
		return result;
	}
	
	@Transactional
	public int addUserLike(LikesVO data) {
		// 클릭시 추천수 반영 (좋아요 테이블 insert/delete)
		LikesDao likesDao = sqlSession.getMapper(LikesDao.class);
		int result;
		if(data.getUserLike() == 1) {			
			result = likesDao.deleteLike(data);			
		}else {
			result = likesDao.insertLike(data);			
		}
		return result;
	}
	
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
	public int removePost(int postSeq) {
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		return boardDao.deletePost(postSeq);
	}
	
	@Transactional
	public CommentVO addComment(CommentVO data) {
		CommentDao commentDao = sqlSession.getMapper(CommentDao.class);
		commentDao.insertCommentAndGetSeq(data);
		CommentVO comment = commentDao.selectOneComment(data.getCmmntSeq());
		return comment;
	}
	
	@Transactional
	public int removeComment(int cmmntSeq) {
		CommentDao commentDao = sqlSession.getMapper(CommentDao.class);
		return commentDao.deleteComment(cmmntSeq);
	}
}
