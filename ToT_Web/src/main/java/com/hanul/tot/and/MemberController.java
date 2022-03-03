package com.hanul.tot.and;

import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import common.CommonService;
import member.MemberServiceImpl;
import member.MemberVO;
import member.TendVO;

@Controller
public class MemberController {
	
	@Autowired private MemberServiceImpl service;
	@Autowired private CommonService common;	
	
	private String naver_client_id = "uGpmI5HP4456GOdaotwq"; 
	//Client ID :  uGpmI5HP4456GOdaotwq  Client Secret : ElhUyTFWhH
	
	private String kakao_client_id = "f8a0db15411522871b73701bf6e16b7b";
	
	
	// 카카오 로그인
	@RequestMapping("/kakaoLogin")
	public String kakaoLogin(HttpSession session) {
		String state = UUID.randomUUID().toString();

		session.setAttribute("state", state);
		//https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=${REST_API_KEY}&redirect_uri=${REDIRECT_URI}
		StringBuffer url = new StringBuffer("https://kauth.kakao.com/oauth/authorize?response_type=code");
		url.append("&client_id=").append(kakao_client_id);
		url.append("&state=").append(state);
		url.append("&redirect_uri=").append("http://localhost/tot/kakaocallback");

		return "redirect:" + url.toString();
	}

	
	
	// 네이버 로그인 요청
		@RequestMapping ("/naverLogin")
		public String naverLogin(HttpSession session) {
			
			String state = UUID.randomUUID().toString();
			
			session.setAttribute("state", state);

			StringBuffer url = new StringBuffer("https://nid.naver.com/oauth2.0/authorize?response_type=code");
			url.append("&client_id=").append(naver_client_id);
			url.append("&state=").append(state);
			url.append("&redirect_uri=http://localhost/tot/navercallback");
			return "redirect:" + url.toString();
		}
		
		
	@RequestMapping("/navercallback")
	public String navercallback(@RequestParam(required = false) String code, 
					HttpSession session, String state, 
					@RequestParam(required = false) String error) {
		
		if ( ! state.equals(session.getAttribute("state")) || error != null ) {
			// state 값이 맞지 않거나 error가 발생해도 토큰 발급 불가
			return "redi rect:/";
		}

		StringBuffer url = new StringBuffer("https://nid.naver.com/oauth2.0/token?grant_type=authorization_code");
		url.append("&client_id=").append(naver_client_id);
		url.append("&client_secret=ElhUyTFWhH");
		url.append("&code=").append(code);
		url.append("&state=").append(state);
		
		JSONObject json = new JSONObject(common.requstAPI(url));
		String token = json.getString("access_token");
		String type = json.getString("token_type");
		
		url = new StringBuffer("https://openapi.naver.com/v1/nid/me");
		json = new JSONObject( common.requestAPI(url, type + " " + token) );		
	
		if (json.getString("resultcode").equals("00")) {
			json = json.getJSONObject("response");
			
			// 회원 정보 DB에 값을 담아서 관리 : MemberVO
			MemberVO vo = new MemberVO();
			vo.setMember_is_naver("naver");
			vo.setMember_name(json.getString("name"));
			vo.setMember_gender(json.has("gender") && json.getString("gender").equals("F") ? "여" : "남");
			
			// 네이버 최초 로그인인 경우 회원정보 저장(insert)
			// 네이버 로그인 이력이 있으면 ..
			if (service.naver_insert(vo));
			else 
				service.social_login(vo);
			
			session.setAttribute("loginInfo", vo);
		}
		return "home"; // 로그인 시 루트(home.jsp)로 이동
	}
		
	//welcome 화면 요청
	@RequestMapping ("/welcome")
	public String welcome(HttpSession session) {
		session.setAttribute("category", "welcome");
		return "member/welcome";
	}
	
	//성향분석 값 입력 요청
	@RequestMapping ("/tend_join")
	public String tend (TendVO vo) {
		
		service.tend_join(vo);
		
		return "member/welcome";
	}
	
	//성향분석 화면 요청
	@RequestMapping ("/tend")
	public String tend(HttpSession session) {
		session.setAttribute("category", "tend");
		return "member/tend";
	}
	
	//비밀번호 찾기 처리 요청
	@ResponseBody
	@RequestMapping ("/find_member_pw")
	public MemberVO find_member_pw(MemberVO vo) {
		return service.find_member_pw(vo);
		
	}
	
	//비밀번호 찾기 화면
	@RequestMapping ("/findpw")
	public String findpw(HttpSession session) {
		session.setAttribute("category", "findpw");
		return "member/findpw";
	}
	
	//아이디 찾기 처리 요청
	@ResponseBody
	@RequestMapping ("/find_member_id")
	public String find_member_id(String member_tel) {
		return service.find_member_id(member_tel);
		
	}
	
	//아이디 찾기 화면
	@RequestMapping ("/findid")
	public String findid(HttpSession session) {
		session.setAttribute("category", "findid");
		return "member/findid";
	}
	
	// 로그아웃 처리 요청
	@RequestMapping ("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginInfo");
		return "home"; // 로그아웃시 루트(home.jsp)로 이동
	}
	
	// 로그인 처리 요청
	@ResponseBody
	@RequestMapping ("/ToTLogin")
	public boolean login(String member_id, String member_pw, HttpSession session) {
		// 화면에서 전송한 아이디, 비밀번호가 일치하는 회원정보를 DB에서 조회
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", member_id);
		map.put("pw", member_pw);
		MemberVO vo = service.member_login(map);
		session.setAttribute("loginInfo", vo);
		return vo == null ? false : true;
		// 결과값이 null 이면 false / null 이 아니면 true
		}
	
	// 로그인 화면 요청
	@RequestMapping ("/login")
	public String login(HttpSession session) {
		session.setAttribute("category", "login");
		return "member/login";
	}
	
	// 회원 가입 처리 요청
	@RequestMapping ("/join")
	public String join (MemberVO vo) {
		
		service.member_join(vo);
		
		return "/member/tend";
	}
	
	// 닉네임 중복확인 요청(not)
	@ResponseBody
	@RequestMapping("/nick_check")
	public boolean nick_check(String member_nick) {
		return service.member_nick_check(member_nick);
	}
	
	// 아이디 중복확인 요청
	@ResponseBody
	@RequestMapping("/id_check")
	public boolean id_check(String member_id) {
		return service.member_id_check(member_id);
	}
	
	// 회원 가입 페이지 요청
	@RequestMapping ("/member")
	public String member(HttpSession session) {
		session.setAttribute("category", "join");
		return "member/join";
	}
	
	
}