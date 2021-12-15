package com.hanul.study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MemberDAO {	//DB연동하여 트랜잭션(요청)을 처리
	private Connection conn;		//연결객체
	private PreparedStatement ps;	//전송객체
	private ResultSet rs;			//결과객체
	
	//DB접속 : ojdbc8.jar(C:\oracle18c\dbhomeXE\jdbc\lib) ▶ WebContent > WEB-INF > lib : 북붙(등록)
	public Connection getConn() {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "hanul";
		String password = "0000";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
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
	public int insertMember(MemberDTO dto) {
		conn = getConn();	//DB접속
		String sql = "insert into Member values(?, ?, ?, ?, ?, ?)";	//SQL문장 작성
		int succ = 0;	//성공여부를 판단할 변수를 초기화
		try {
			ps = conn.prepareStatement(sql);	//전송객체 생성
			ps.setString(1, dto.getName());		//매개변수 값을 할당(세팅)
			ps.setString(2, dto.getId());
			ps.setString(3, dto.getPw());
			ps.setInt(4, dto.getAge());
			ps.setString(5, dto.getAddr());
			ps.setString(6, dto.getTel());
			succ = ps.executeUpdate();			//SQL문장 실행
		} catch (Exception e) {	//예외처리
			e.printStackTrace();
			System.out.println("insertMember() Exception!!!");
		} finally {
			dbClose();	//DB접속 해제			
		}
		return succ;	//결과를 리턴
	}//insertMember()
	
	//전체회원 목록검색
	public ArrayList<MemberDTO> searchAllMember() {
		conn = getConn();
		String sql = "select * from Member";
		ArrayList<MemberDTO> list = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String name = rs.getString("name");
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				int age = rs.getInt("age");
				String addr = rs.getString("addr");
				String tel = rs.getString("tel");
				MemberDTO dto = new MemberDTO(name, id, pw, age, addr, tel);
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("searchAllMember() Exception!!!");
		} finally {
			dbClose();
		}
		return list;
	}//searchAllMember()
	
	//회원정보 삭제
	public int deleteMember(String id) {
		conn = getConn();
		String sql = "delete from Member where id = ?";
		int succ = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			succ = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("deleteMember() Exception!!!");
		} finally {
			dbClose();
		}
		return succ;
	}//deleteMember()
	
	//수정할 회원정보를 검색
	public MemberDTO getById(String id) {
		conn = getConn();
		String sql = "select * from Member where id = ?";
		MemberDTO dto = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				dto = new MemberDTO();
				dto.setName(rs.getString("name"));
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setAge(rs.getInt("age"));
				dto.setAddr(rs.getString("addr"));
				dto.setTel(rs.getString("tel"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getById() Exception!!!");
		} finally {
			dbClose();
		}
		return dto;
	}//getById()
	
	//회원정보 수정하기
	public int updateMember(MemberDTO dto) {
		conn = getConn();
		String sql = "update Member set name=?, pw=?, age=?, addr=?, tel=? where id=?";
		int succ = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getPw());
			ps.setInt(3, dto.getAge());
			ps.setString(4, dto.getAddr());
			ps.setString(5, dto.getTel());
			ps.setString(6, dto.getId());
			succ = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("updateMember() Exception!!!");
		} finally {
			dbClose();
		}
		return succ;
	}//updateMember()
	
}//class
