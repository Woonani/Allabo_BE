package com.allabo.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allabo.service.TeamService;
import com.allabo.vo.TeamAndMemberVO;
import com.allabo.vo.TeamVO;
import com.allabo.vo.UsersTeamVO;

@RestController
@RequestMapping("/api/team")
public class TeamController {
	@Autowired
	private TeamService teamService;
	
//	@Autowired
//	private MemberService memberService;
	
	@GetMapping("/list/{userId}")
	public ResponseEntity<?> getTeamListById(@PathVariable String userId){
		List<TeamAndMemberVO> data = new ArrayList<>();
		data = teamService.getTeamList(userId);
		System.out.println("teamList: "+ data);

		return new ResponseEntity<>(data, HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> addTeam(@RequestBody TeamAndMemberVO data){
		System.out.println("controller받은 : " + data);
		
		TeamAndMemberVO result = teamService.addTeam(data);		

		return new ResponseEntity<>(result, HttpStatus.OK); // 뷰페이지엔 team_seq를 넘겨줘야함 ( result );
	}
	
	@PatchMapping("/{utSeq}")
	public ResponseEntity<?> modifyTeam(@PathVariable int utSeq, @RequestBody TeamVO data){
		//TO DO : 호스트만 변경 가능하도록
		System.out.println("수정전 team 정보 : " + utSeq + "/" + data);
		// TeamVO에 수정된 teamName 또는 description 담겨옴, utSeq는 수정된 하나의 값 반환을 위함.
		TeamAndMemberVO result = teamService.modifyTeam(utSeq, data);
		System.out.println("수정된 team 정보 : " + result);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@DeleteMapping("/{teamSeq}")
	public ResponseEntity<?> removeTeam(@PathVariable int teamSeq){
		//TO DO : 호스트만 삭제 가능하도록
		int result = teamService.removeTeam(teamSeq);
		// result = 1 팀이 삭제되었습니다. , result = 0 삭제할 팀이 없습니다...?
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
}