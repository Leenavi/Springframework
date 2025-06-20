package org.zerock.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/sample/")
public class SampleController {

	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MEMBER')")
	@GetMapping("/annoMember")
	public void doMember2() {
		log.info("logined annotation member");
	}
	
	@GetMapping("/all") //모든 사용자가 호출 가능
	public void doAll() {
		log.info("do all can access everybody");
	}
	
	@GetMapping("/member")  //로그인 회원만 호출 가능
	public void doMember() {
		log.info("logined member");
	}
	
	@GetMapping("/admin") //관리자만 호출 가능
	public void doAdmin() {
		log.info("admin only");
	}
}
