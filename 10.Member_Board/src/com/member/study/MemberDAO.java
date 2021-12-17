package com.member.study;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import net.sf.json.JSONArray;

public class MemberDAO {
	//DB 접속 : myBatis
	private static SqlSessionFactory sqlMapper;
	static {
		try {
			String resource = "com/hanul/mybatis/SqlMapConfig.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("SqlSessionFactory Exception!!!");
		}
	}//초기화 블럭
	
	//ID 조회 : 중복검사
	public String getMember_idList() {
		SqlSession session = sqlMapper.openSession();
		List<MemberDTO> list = null;
		list = session.selectList("getMember_idList");
		session.close();
		
		JSONArray array = JSONArray.fromObject(list);
		String json = array.toString();
		return json;
	}//getMember_idList()
	
	//회원가입
	public int joinMember(MemberDTO dto) {
		SqlSession session = sqlMapper.openSession();
		int succ = 0;
		succ = session.insert("joinMember", dto);
		session.commit();
		session.close();
		return succ;
	}//joinMember()
	
	//회원여부
	public int isMember(MemberDTO dto) {
		SqlSession session = sqlMapper.openSession();
		MemberDTO isDto = null;
		isDto = session.selectOne("isMember", dto);
		session.close();
		
		int result = -1;
		if(isDto != null) {	//검색결과가 있다 : 아이디 존재
			if(isDto.getMember_pw().equals(dto.getMember_pw())) {
				result = 1;	//비밀번호 일치
			}else {
				result = 0;	//비밀번호 불일치
			}
		}else {				//검색결과가 없다 : 아이디가 존재하지 않는다.
			result = -1;
		}
		return result;
	}//isMember()
	
	//전체회원 목록 검색
	public List<MemberDTO> getMember_AllList() {
		SqlSession session = sqlMapper.openSession();
		List<MemberDTO> list = null;
		list = session.selectList("getMember_AllList");
		session.close();
		return list;
	}//getMember_AllList()
	
	//회원정보 삭제
	public int deleteMember(String member_id) {
		SqlSession session = sqlMapper.openSession();
		int succ = 0;
		succ = session.delete("deleteMember", member_id);
		session.commit();
		session.close();
		return succ;
	}//deleteMember()
	
	//한명의 회원정보를 검색
	public MemberDTO getDetailMember(String member_id) {
		SqlSession session = sqlMapper.openSession();
		MemberDTO dto = null;
		dto = session.selectOne("getDetailMember", member_id);
		session.close();
		return dto;		
	}//getDetailMember()
	
	//회원의 비밀번호 검색
	public String getMember_pw(String id) {
		SqlSession session = sqlMapper.openSession();
		String member_pw = null;
		member_pw = session.selectOne("getMember_pw", id);
		session.close();
		return member_pw;
	}//getMember_pw()
	
	
	
	
	
	
}//class
