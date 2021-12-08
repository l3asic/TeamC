package com.hanul.study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BookDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public Connection getConn() {	//db접속 연결
		String url = "jdbc:oracle:thin:@127.0.1:1521:XE";
		String user = "hanul";
		String password = "0000";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getConn() Exception!!");
		}
		return conn;						
	}//getConn()
	
	public void dbClose() {		//db접속 종료
		try {
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(conn != null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("dbClose() Exception!");
		}
	}//dbClose()
	
	public int insertBook(BookDTO dto) { //book 추가
		conn = getConn();	
		String sql = "insert into tblBook values(?, ?, ?, ?, ?, ?, ?)";	
		int succ = 0;	
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getTitle());
			ps.setString(2, dto.getName());
			ps.setString(3, dto.getIsbn());
			ps.setString(4, dto.getComp());
			ps.setInt(5, dto.getCost());
			ps.setInt(6, dto.getQty());
			ps.setInt(7, dto.getPrice());	 
			succ = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("insertBook() Exception !!");
		}finally {
			dbClose(); 		
		}
		return succ;	//도서 추가 성공여부 리턴
	}//insertBook()
		
	
	public int deleteBook(String isbn) {	//book 삭제
		conn = getConn();	
		String sql = "delete from tblbook where isbn = ?";	
		int succ = 0;	
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, isbn);		
			succ = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("deleteBook() Exception !!");
		}finally {
			dbClose(); 		
		}
		return succ;	
	}//deleteBook
	public int deleteAll(BookDTO dto) {	//book 전체삭제
		conn = getConn();	
		String sql = "delete from tblbook";	
		int succ = 0;	
		try {
			ps = conn.prepareStatement(sql);			
			succ = ps.executeUpdate();
			dto.setDeleteAll(0);	//전체 삭제하고 전체삭제모드 해제
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("deleteAll() Exception !!");
		}finally {
			dbClose(); 		
		}
		return succ;	
	}//deleteAll
	
	public ArrayList<BookDTO> getAllList() {	//전체 도서목록 조회
		conn = getConn();
		String sql = "select * from tblbook";
		ArrayList<BookDTO> list = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();		
			while (rs.next()) {
				BookDTO dto = new BookDTO();		
				dto.setTitle(rs.getString("TITLE"));
				dto.setName(rs.getString("name"));
				dto.setIsbn(rs.getString("isbn"));
				dto.setComp(rs.getString("comp"));
				dto.setCost(rs.getInt("cost"));
				dto.setQty(rs.getInt("qty"));
				dto.setPrice(rs.getInt("price"));
				list.add(dto); 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return list;
	}//getAllList()
	
	public int checkIsbn(BookDTO dto) {		//isbn 중복확인
		conn = getConn();
		String sql = "select count(*) as chk from tblbook where isbn = ?";
		int check = 0;	
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getIsbn());		
			rs = ps.executeQuery();
			while(rs.next()) {				
				check = rs.getInt("chk");				
				
			}						
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("checkIsbn() Exception !!");
		}finally {
			dbClose(); 		
		}
		return check;	//중복될시 1이상 반환, 아니면 0반환
		
		
	}//checkIsbn
	
	public int updateBook(BookDTO dto) { //book 수정
		conn = getConn();	
		String sql = "update tblBook set title = ?, name = ?, comp = ?, cost = ?, qty = ?, price = ? where isbn = ?";	
		int succ = 0;	
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getTitle());
			ps.setString(2, dto.getName());
			ps.setString(3, dto.getComp());
			ps.setInt(4, dto.getCost());
			ps.setInt(5, dto.getQty());
			ps.setInt(6, dto.getPrice());	 
			ps.setString(7, dto.getIsbn());
			succ = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("updateBook() Exception !!");
		}finally {
			dbClose(); 		
		}
		return succ;	//도서 수정 성공여부 리턴
	}//insertBook()
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//class BookDAO
