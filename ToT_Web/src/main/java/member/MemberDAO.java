package member;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO implements MemberService {

	@Autowired @Qualifier("cteam") private SqlSession sql;
	@Override
	public boolean member_join(MemberVO vo) {
		return sql.insert("member.mapper.memberjoin", vo) == 1 ? true : false;
	}

	@Override
	public boolean tend_join(TendVO vo) {
		return sql.insert("member.mapper.tendjoin", vo) == 1 ? true : false;
	}
	
	public boolean member_nick_check(String member_nick) {
		return (Integer) sql.selectOne("member.mapper.membernick_check", member_nick) == 0 ? true : false;
	}

	
	@Override
	public boolean member_id_check(String member_id) {
		return (Integer) sql.selectOne("member.mapper.memberid_check", member_id) == 0 ? true : false;
	}

	@Override
	public MemberVO member_login(HashMap<String, String> map) {
		return sql.selectOne("member.mapper.memberlogin", map);
	}


	public String member_find_id(String member_tel) {
		
		return sql.selectOne("member.mapper.find_member_id", member_tel);
	}

	
	public MemberVO member_find_pw(MemberVO vo) {
		
		return sql.selectOne("member.mapper.find_member_pw", vo);
	}

	
	@Override
	public boolean kakao_insert(MemberVO vo) {
		return sql.insert("member.mapper.kakao_login", vo) == 1 ? true : false;
	}
	@Override
	public boolean naver_insert(MemberVO vo) {
		return sql.insert("member.mapper.naver_login", vo) == 1 ? true : false;
	}
	
	@Override
	public int naver_check(MemberVO vo) {
		// TODO Auto-generated method stub
		return sql.selectOne("member.mapper.naver_check", vo);
	}

	@Override
	public boolean social_login(MemberVO vo) {
		// TODO Auto-generated method stub
		return false;
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

	
}
