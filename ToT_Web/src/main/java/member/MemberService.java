package member;

import java.util.HashMap;

public interface MemberService {
	// CRUD 형태를 가짐

	// 회원 가입 성공 여부 (C)
	boolean member_join(MemberVO vo);
	
	// 로그인 - 아이디, 비번 일치하는 회원정보 조회 (R)
	MemberVO member_login(HashMap<String, String> map);
	
	//아이디 찾기
	boolean findid(String member_tel);
	
	//비밀번호 찾기
	boolean findpw(MemberVO vo);
	
	// 아이디 중복확인 (R)
	boolean member_id_check(String id);
	
	// 닉네임 중복확인 (R)
	boolean member_nick_check(String nick);
	
	// 소셜 회원 정보 존재여부 (R)
	int naver_check(MemberVO vo);

	
	// kakao login
		boolean kakao_insert(MemberVO vo);
	
	// naver login
	boolean naver_insert(MemberVO vo);
	
	// 소셜 회원 정보 존재여부 (R)
	boolean social_login(MemberVO vo);
	
	
	
	// 회원가입시 성향분석
	boolean tend_join(TendVO vo);

}
