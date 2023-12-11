package com.allabo.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allabo.service.TeamService;

@RestController
@RequestMapping("/api/team")
public class TeamController {
	@Autowired
	private TeamService teamService;
	
	@PostMapping("/post-team")
	public ResponseEntity<?> addTeam(@RequestBody HashMap<String, String> data){
		System.out.println("teamVO : " + data);
		
		Map<String, String> team = new HashMap<>();
		team.put("teamName", data.get("teamName"));
		team.put("description", data.get("description"));
		team.put("userId", data.get("userId"));
		
		// 트랜젝션 걸기
		int result = teamService.addTeam(team);
		
		if(result == 1) {
			// users_team 테이블에도 insert
		}else {
			//roll back
		}
		return null;
	}
	
}