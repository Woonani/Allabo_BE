package com.allabo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.allabo.service.BoardService;
import com.allabo.vo.CommentVO;
import com.allabo.vo.LikesVO;
import com.allabo.vo.PostVO;

@RestController
@RequestMapping("/api/board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/{teamSeq}")  // 페이지 네이션 후 post로 바꾸고, n개씩,r번째
	public ResponseEntity<?> getBoard(@PathVariable int teamSeq, @RequestParam String tag, int noPerPage, int page, String searchTag, String searchWord){
		//게시판 정보 가져오기
		System.out.println("파람확인 : "+ teamSeq +", "+ tag +", "+  noPerPage +", "+  page+", "+  searchTag +", "+  searchWord);
		System.out.println("tag : "+ tag instanceof String);
		Map<Object,Object> data = boardService.getPostList(teamSeq, tag, noPerPage, page, searchTag, searchWord);
		System.out.println("BoardController-getBoard : " + data);

		return new ResponseEntity<> (data, HttpStatus.OK);
	}
	
	@GetMapping("/viewcount/{postSeq}")
	public ResponseEntity<?> addViewCount(@PathVariable int postSeq){
		// 클릭시 조회수 반영
		boardService.addViewCount(postSeq);
		return new ResponseEntity<> (HttpStatus.OK);
	}
	
	@GetMapping("/post/{postSeq}/{userId}") 
	public ResponseEntity<?> getPost(@PathVariable int postSeq, @PathVariable String userId){
		// 게시글 정보 가져오기
		Map<Object, Object> data = boardService.getPost(postSeq, userId);
		return new ResponseEntity<> (data, HttpStatus.OK);
	}
	
	@GetMapping("/post/editing/{postSeq}") 
	public ResponseEntity<?> getPostEdit(@PathVariable int postSeq){
		// 수정할 게시글 정보 가져오기
		PostVO data = boardService.getPostEdit(postSeq);
		return new ResponseEntity<> (data, HttpStatus.OK);
	}
	
	
	@PostMapping("/userlike")
	public ResponseEntity<?> addUserLike(@RequestBody LikesVO data){
		System.out.println("addUserLike입장 - "+data);
		// 클릭시 조회수 반영
		boardService.addUserLike(data);
		return new ResponseEntity<> (HttpStatus.OK);
	}
	
	@PostMapping("/post/writing")
	public ResponseEntity<?> addPost(@RequestBody PostVO data){
		// 글 쓰기
		System.out.println("BoardController-addPost 1 : " + data);
		PostVO post = boardService.addPost(data);
		System.out.println("BoardController-addPost 2 : " + post);

		return new ResponseEntity<> (post, HttpStatus.OK);
	}
	
	@PutMapping("/post/editing") 
	public ResponseEntity<?> setPostEdit(@RequestBody PostVO post){
		// 수정할 게시글 정보 가져오기
		int result = boardService.setPostEdit(post);
		return new ResponseEntity<> (result, HttpStatus.OK);
	}
	
	@DeleteMapping("/post/{postSeq}")
	public ResponseEntity<?> removePost(@PathVariable int postSeq){
		boardService.removePost(postSeq);
		return new ResponseEntity<> (HttpStatus.OK);
	}
	
	@PostMapping("/comment")
	public ResponseEntity<?> addComment(@RequestBody CommentVO data){
		CommentVO comment =  boardService.addComment(data);
		return new ResponseEntity<> (comment, HttpStatus.OK);
	}
	
	@DeleteMapping("/comment/{cmmntSeq}")
	public ResponseEntity<?> removeComment(@PathVariable int cmmntSeq){
		int result =  boardService.removeComment(cmmntSeq);
		return new ResponseEntity<> (HttpStatus.OK);
	}
	
	
}
