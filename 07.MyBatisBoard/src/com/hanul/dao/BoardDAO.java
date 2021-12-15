package com.hanul.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.hanul.dto.BoardDTO;
import com.hanul.dto.SearchDTO;

public class BoardDAO {
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
	
	//전체목록 조회 : select
	public List<BoardDTO> boardSearchAll() {
		SqlSession session = sqlMapper.openSession();	//session 활성화
		List<BoardDTO> list = null;	//검색결과가 저장될 컬렉션 객체를 초기화
		list = session.selectList("boardSearchAll");	//select 쿼리를 수행할 메소드를 호출
		session.close();	//session 종료
		return list;		//결과를 리턴
	}//boardSearchAll()
	
	//글 등록 : insert
	public int boardInsert(BoardDTO dto) {
		SqlSession session = sqlMapper.openSession();	//session 활성화
		//alert 창을 사용할 경우에는 succ를 return 해야 한다.
		// ▶ out.println(); 이용한 script 코드 구현
		//alert 창을 사용하지 않을 경우에는 succ가 필요없다.
		// ▶ ActionForward를 이용한 페이지 전환
		int succ = 0;	//성공여부를 저장할 변수를 초기화
		succ = session.insert("boardInsert", dto);	//insert 쿼리를 수행할 메소드를 호출
		session.commit();	//커밋
		session.close();	//session 종료
		return succ;		//결과를 리턴
	}//boardInsert()
	
	//글 조회 : select
	public BoardDTO boardDetail(int b_num) {
		SqlSession session = sqlMapper.openSession();
		BoardDTO dto = null;
		dto = session.selectOne("boardDetail", b_num);
		session.close();
		return dto;
	}//boardDetail()
	
	//조회수 증가 : update
	public void boardReadCountUpdate(int b_num) {
		SqlSession session = sqlMapper.openSession();
		session.update("boardReadCountUpdate", b_num);
		session.commit();
		session.close();
	}//boardReadCountUpdate()
	
	//글 삭제 : delete
	public void boardDelete(int b_num) {
		SqlSession session = sqlMapper.openSession();
		//alert 창을 사용하지 않을 경우에는 succ가 필요없다.
		// ▶ ActionForward를 이용한 페이지 전환
		//int succ = 0;
		session.delete("boardDelete", b_num);
		session.commit();
		session.close();
	}//boardDelete()
	
	//글 수정 : update
	public void boardUpdate(BoardDTO dto) {
		SqlSession session = sqlMapper.openSession();
		session.update("boardUpdate", dto);
		session.commit();
		session.close();
	}//boardUpdate()
	
	//조건검색 : select
	public List<BoardDTO> boardSearch(SearchDTO dto) {
		SqlSession session = sqlMapper.openSession();
		List<BoardDTO> list = null;
		list = session.selectList("boardSearch", dto);
		session.close();
		return list;
	}//boardSearch()
	
	
	
	
	
	
	
}//class
