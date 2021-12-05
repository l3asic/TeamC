package com.hanul.study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MemberDAO {			//DB와 연동
	private Connection conn;		//연결객체
	private PreparedStatement ps;	//전송객체
	private ResultSet rs;			//결과객체
	
	//DB접속 : ojdbc8.jar(C:\oracle18c\dbhomeXE\jdbc\lib) → WebContent > WEB-INF > lib : 복&붙 ▶ 정적로딩
	public Connection getConn() {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "hanul";
		String password = "0000";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	//동적로딩
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getConn() Exception!!!");
		}
		return conn;
	}//getConn()
	
	//DB접속 해제
	public void dbClose() {
		try {
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(conn != null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("dbClose() Exception!!!");
		}
	}//dbClose()

	//회원가입
	public int memberInsert(MemberDTO dto) {
		conn = getConn();	//DB접속
		String sql = "insert into Member values(?, ?, ?, ?, ?, ?)";	//SQL 문장 작성
		int succ = 0;		//SQL 문장의 성공여부를 판단하기 위한 변수
		try {
			ps = conn.prepareStatement(sql);	//전송객체 생성
			ps.setString(1, dto.getName());		//매개변수 값을 세팅
			ps.setString(2, dto.getId());
			ps.setString(3, dto.getPw());
			ps.setInt(4, dto.getAge());
			ps.setString(5, dto.getAddr());
			ps.setString(6, dto.getTel());
			succ = ps.executeUpdate();			//SQL 문장을 실행
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("memberInsert() Exception!!!");
		} finally {
			dbClose();		//DB접속 해제
		}
		return succ;		//결과(성공여부)를 리턴
	}//memberInsert()
	
	//전체회원 목록 검색
	public ArrayList<MemberDTO> memberSearchAll() {
		conn = getConn();	//DB접속
		String sql = "select * from Member";	//SQL 문장 작성
		ArrayList<MemberDTO> list = new ArrayList<>();	//최종결과를 저장할 컬렉션 자료구조를 생성
		try {
			ps = conn.prepareStatement(sql);	//전송객체 생성
			rs = ps.executeQuery();				//SQL문장 실행 : select → ResultSet 결과객체 생성
			while(rs.next()) {
				/* DTO 클래스의 초기화된 생성자 메소드를 이용하여 DTO 객체를 생성하는 방법
				String name = rs.getString("name");
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				int age = rs.getInt("age");
				String addr = rs.getString("addr");
				String tel = rs.getString("tel");
				MemberDTO dto = new MemberDTO(name, id, pw, age, addr, tel);
				*/
				
				//디폴트 생성자 메소드를 이용하여 DTO 객체를 생성하는 방법
				MemberDTO dto = new MemberDTO();
				dto.setName(rs.getString("name"));
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setAge(rs.getInt("age"));
				dto.setAddr(rs.getString("addr"));
				dto.setTel(rs.getString("tel"));				
				
				list.add(dto);
			}			
		} catch (Exception e) {
			e.printStackTrace();	//예외 발생 시 상세하게 예외 메세지를 콘솔창에 출력
			System.out.println("memberSearchAll() Exception!!!");	//예외 메세지를 직접 작성하여 출력
		} finally {
			dbClose();		//DB접속 해제
		}
		return list;		//결과를 리턴
	}//memberSearchAll()

	//회원정보 삭제
	public int memberDelete(String id) {
		conn = getConn();	//DB접속
		String sql = "delete from Member where id = ?";	//SQL 문장 작성
		int succ = 0;		//성공여부를 판단하기 위한 변수를 초기화
		try {
			ps = conn.prepareStatement(sql);	//전송객체생성
			ps.setString(1, id);				//매개변수 값을 세팅
			succ = ps.executeUpdate();			//SQL문장 실행
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("memberDelete() Exception!!!");
		} finally {
			dbClose();		//DB접속 해제
		}
		return succ;		//결과값을 리턴
	}//memberDelete()
	
}//class
