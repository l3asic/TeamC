package com.hanul.tot.and;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
	// 로그인 화면 요청
		@RequestMapping ("/member_login")
		public String login() {
			
			return "member/login";
		}
}
