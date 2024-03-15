package com.allabo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allabo.service.MemberService;
import com.allabo.vo.TeamAndMemberVO;
import com.allabo.vo.UsersVO;

@RestController
@RequestMapping("/api/member")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/search/{userId}")
	public ResponseEntity<?> getSearchList(@PathVariable String userId){
		List<UsersVO> data = new ArrayList<>();
		data = memberService.searchUserList(userId);
		return new ResponseEntity<>(data, HttpStatus.OK);
	}
	
	@GetMapping("/{teamSeq}")
	public ResponseEntity<?> getMemberList(@PathVariable int teamSeq){
		List<TeamAndMemberVO> data = new ArrayList<>();
		data = memberService.getMemberList(teamSeq);
		return new ResponseEntity<>(data, HttpStatus.OK);
	}
	
	@PostMapping("/{teamSeq}") // 팀생성 후 사용하는 초대 기능
	public ResponseEntity<?> inviteTeamMember(@PathVariable int teamSeq, @RequestBody Map<String, List<String>> idList){
//		System.out.println(idList);
//		System.out.println(idList.get("invitees"));
		int result = memberService.inviteMembers(teamSeq, idList.get("invitees"));
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@PatchMapping("/leaving/{utSeq}")
	public ResponseEntity<?> leaveTeam(@PathVariable int utSeq){
		//TO DO : 호스트만 삭제 가능하도록
		int result = memberService.leaveTeam(utSeq);
		// result = 1 팀이 삭제되었습니다. , result = 0 삭제할 팀이 없습니다...?
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

}
