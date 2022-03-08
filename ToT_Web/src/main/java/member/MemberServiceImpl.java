package member;

import java.util.HashMap;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired private MemberDAO dao;
	
	@Override
	public boolean member_join(MemberVO vo) {
		return dao.member_join(vo);
	}

	public boolean tend_join(TendVO vo) {
		return dao.tend_join(vo);
	}

	public boolean member_nick_check(String member_nick) {
		return dao.member_nick_check(member_nick);
	}
	
	@Override
	public boolean member_id_check(String member_id) {
		return dao.member_id_check(member_id);
	}

	@Override
	public MemberVO member_login(HashMap<String, String> map) {
		return dao.member_login(map);
	}


	@Override
	public boolean kakao_insert(MemberVO vo) {
		return dao.kakao_insert(vo);
	}
	@Override
	public boolean naver_insert(MemberVO vo) {
		return dao.naver_insert(vo);
	}
	@Override
	public int naver_check(MemberVO vo) {
		// TODO Auto-generated method stub
		return dao.naver_check(vo);
	}
	@Override
	public boolean social_login(MemberVO vo) {
		// 소셜회원정보 신규저장(C)
		return dao.social_login(vo);
	}

	public String find_member_id(String member_tel) {
		return dao.member_find_id(member_tel);
	}
	
	public MemberVO find_member_pw(MemberVO vo) {
		return dao.member_find_pw(vo);
	}

	@Override
	public boolean findid(String member_tel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean findpw(MemberVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean member_is_naver() {
		// TODO Auto-generated method stub
		return false;
	}

	

}
