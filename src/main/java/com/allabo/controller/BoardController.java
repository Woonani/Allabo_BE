package com.allabo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.allabo.service.BoardService;
import com.allabo.vo.PostVO;

@RestController
@RequestMapping("/api/board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
//	public List<PostVO> getPostList(int teamSeq, String tag, int noPerPage, int page ){
	@GetMapping("/{teamSeq}")  // 페이지 네이션 후 post로 바꾸고, n개씩,r번째
	public ResponseEntity<?> getBoard(@PathVariable int teamSeq, @RequestParam String tag, int noPerPage, int page, String searchTag, String searchWord){
		System.out.println("파람확인 : "+ teamSeq +", "+ tag +", "+  noPerPage +", "+  page+", "+  searchTag +", "+  searchWord);
		System.out.println("tag : "+ tag instanceof String);
		Map<Object,Object> data = boardService.getPostList(teamSeq, tag, noPerPage, page, searchTag, searchWord);
		System.out.println("BoardController-getBoard : " + data);

		return new ResponseEntity<> (data, HttpStatus.OK);
	}
	
	@PostMapping("/writing")
	public ResponseEntity<?> addPost(@RequestBody PostVO data){
		System.out.println("BoardController-addPost 1 : " + data);
		PostVO post = boardService.addPost(data);
		System.out.println("BoardController-addPost 2 : " + post);

		return new ResponseEntity<> (post, HttpStatus.OK);
	}
	
	
}
