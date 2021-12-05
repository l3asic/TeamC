package com.hanul.study;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDAO {
	//기존 JDBC 모델에서는 Connection(연결객체)을 먼저 만들었지만,
	//myBatis 경우 SqlSessionFactoty 객체를 먼저 생성
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
	
	//회원가입
	public int memberInsert(MemberDTO dto) {
		//SqlSessionFactory(sqlMapper)에서 session 활성화
		SqlSession session = sqlMapper.openSession();
		
		int succ = 0;	//성공여부 판단
		
		//insert 작업(SQL문장작성) → memberMapper.xml
		succ = session.insert("memberInsert", dto);
		
		session.commit();	//커밋명령
		
		session.close();	//session 종료
		
		return succ;		//결과를 리턴		
	}//memberInsert()
	
	//전체회원 목록검색
	public List<MemberDTO> memberSearchAll() {
		SqlSession session = sqlMapper.openSession();
		List<MemberDTO> list = null;
		list = session.selectList("memberSearchAll");
		session.close();
		return list;
	}//memberSearchAll()
	
	//회원정보 삭제
	public int memberDelete(String id) {
		SqlSession session = sqlMapper.openSession();
		int succ = 0;
		succ = session.delete("memberDelete", id);
		session.commit();
		session.close();
		return succ;
	}//memberDelete()
	
	//회원정보 검색
	public MemberDTO getById(String id) {
		SqlSession session = sqlMapper.openSession();
		MemberDTO dto = null;
		dto = session.selectOne("getById", id);
		session.close();
		return dto;
	}//getById()
	
	//회원정보 수정
	public int memberUpdate(MemberDTO dto) {
		SqlSession session = sqlMapper.openSession();
		int succ = 0;
		succ = session.update("memberUpdate", dto);
		session.commit();
		session.close();
		return succ;
	}//memberUpdate()
	
	//조건검색
	public List<MemberDTO> memberSearch(SearchDTO dto) {
		SqlSession session = sqlMapper.openSession();
		List<MemberDTO> list = null;
		list = session.selectList("memberSearch", dto);
		session.close();
		return list;
	}//memberSearch()
	
	
	
	
	
	
}//class
