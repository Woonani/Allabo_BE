package com.allabo.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allabo.service.TeamService;
import com.allabo.service.UsersTeamService;
import com.allabo.vo.TeamVO;
import com.allabo.vo.UsersTeamVO;

@RestController
@RequestMapping("/api/team")
public class TeamController {
	@Autowired
	private TeamService teamService;
	
	@Autowired
	private UsersTeamService usersTeamService;
	
	// 트랜젝션 어노테이션 추가 
	// 메서드 내에서 예외가 발생하면 teamService.addTeam 및 usersTeamService.addUsersTeam 모두 롤백
	// 모든 것이 성공적으로 완료되면 트랜잭션이 커밋됨
	@Transactional  
	@PostMapping("/register")
	public ResponseEntity<?> addTeam(@RequestBody HashMap<String, String> data){
		System.out.println("teamVO : " + data);
		
		TeamVO team = new TeamVO();
		team.setTeamName(data.get("teamName"));
		team.setDescription(data.get("description"));
		
		int result = teamService.addTeam(team);		
		
		if(result == 1) {
			UsersTeamVO usersTeam = new UsersTeamVO();
			usersTeam.setNick(data.get("nick"));
			usersTeam.setRole(1);
			usersTeam.setTeamId(team.getTeamId());
			usersTeam.setUserid(data.get("userId"));
			
			int result2 = usersTeamService.addUsersTeam(usersTeam);
			
			if(result2 == 1) {
				return new ResponseEntity<>(usersTeam, HttpStatus.OK);
			}else {
//				result2 실패시 >> result1 rollback
//				RuntimeException이 롤백을 트리거
				throw new RuntimeException("UsersTeam 추가 실패");
			}
		}else {
//			return new ResponseEntity<>(1, HttpStatus.INTERNAL_SERVER_ERROR);
			throw new RuntimeException("Team 추가 실패");
		}
	}
	
}