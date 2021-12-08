package com.hanul.study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserDAO {

	private Connection conn; // 연결객체
	private PreparedStatement ps; // 전송객체
	private ResultSet rs; // 결과객체

	// DB접속 : ojdbc8.jar(C:\oracle18c\dbhomeXE\jdbc\lib) ▶ WebContent > WEB-INF >
	// lib : 복붙(등록)
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
	}// getConn()

	// DB접속 해제
	public void dbClose() {
		try {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("dbClose() Exeptin!!!");
		}
	}// dbClose()

	public ArrayList<UserDTO> markQna() {
		// 트라이캐치 (반복문(채점 하면서 db ox컬럼에 정답여부 삽입))

		return null;

	}

	public int insertOmr(OmrDTO dto) { // 사용자가 입력한 답안
		conn = getConn();
		String sql = "insert into answer_c values(?,?,?,?,?,?,?,?,?,?,?)";
		int succ = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setInt(2, dto.getAnswer1());
			ps.setInt(3, dto.getAnswer2());
			ps.setInt(4, dto.getAnswer3());
			ps.setInt(5, dto.getAnswer4());
			ps.setInt(6, dto.getAnswer5());
			ps.setInt(7, dto.getAnswer6());
			ps.setInt(8, dto.getAnswer7());
			ps.setInt(9, dto.getAnswer8());
			ps.setInt(10, dto.getAnswer9());
			ps.setInt(11, dto.getAnswer10());
			succ = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("insertAnswer() Exception!!!");
		} finally {
			dbClose();
		}
		return succ;
	}// deleteOmr()

	public int deleteOmr(String id) {
		conn = getConn(); // DB접속
		String sql = "delete from answer_c where id = ?"; // SQL 문장 작성
		int succ = 0; // 성공여부를 판단하기 위한 변수를 초기화
		try {
			ps = conn.prepareStatement(sql); // 전송객체생성
			ps.setString(1, id); // 매개변수 값을 세팅
			succ = ps.executeUpdate(); // SQL문장 실행
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("deleteAnswer() Exception!!!");
		} finally {
			dbClose(); // DB접속 해제
		}
		return succ; // 결과값을 리턴
	}// deleteOmr()

<<<<<<< HEAD
	public ArrayList<CorrectAnsDTO> CorrectAns() { // 정답 리스트
		conn = getConn();
		String sql = "select * from correctanswer_C";
		ArrayList<CorrectAnsDTO> c_list = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				int ca1 = rs.getInt("ca1");
				int ca2 = rs.getInt("ca2");
				int ca3 = rs.getInt("ca3");
				int ca4 = rs.getInt("ca4");
				int ca5 = rs.getInt("ca5");
				int ca6 = rs.getInt("ca6");
				int ca7 = rs.getInt("ca7");
				int ca8 = rs.getInt("ca8");
				int ca9 = rs.getInt("ca9");
				int ca10 = rs.getInt("ca10");

				CorrectAnsDTO dto = new CorrectAnsDTO(ca1, ca2, ca3, ca4, ca5, ca6, ca7, ca8, ca9, ca10);
				c_list.add(dto);

			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("정답불러오기 에러");
		} finally {
			dbClose();
		}
		return c_list;
	}

	public ArrayList<OmrDTO> myAns(String id) { // db에 저장된 사용자 답안
		conn = getConn();
		String sql = "select * from answer_c where id = ? order by id asc";
=======
	public ArrayList<OmrDTO> myAns(String id) { // db에 저장된 사용자 답안
		conn = getConn();
		String sql = "select * from answer_c where id=?";
>>>>>>> ChaMinHwan
		ArrayList<OmrDTO> m_list = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				int answer1 = rs.getInt("answer1");
				int answer2 = rs.getInt("answer2");
				int answer3 = rs.getInt("answer3");
				int answer4 = rs.getInt("answer4");
				int answer5 = rs.getInt("answer5");
				int answer6 = rs.getInt("answer6");
				int answer7 = rs.getInt("answer7");
				int answer8 = rs.getInt("answer8");
				int answer9 = rs.getInt("answer9");
				int answer10 = rs.getInt("answer10");

				OmrDTO dto = new OmrDTO(id, answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8,
						answer9, answer10);
				m_list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("제출답안 에러");
		} finally {
			dbClose();
		}
		return m_list;
	}

<<<<<<< HEAD
=======
	public ArrayList<CorrectAnsDTO> CorrectAns() { // 정답 리스트
		conn = getConn();
		String sql = "select * from correctanswer_C";
		ArrayList<CorrectAnsDTO> c_list = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				int ca1 = rs.getInt("ca1");
				int ca2 = rs.getInt("ca2");
				int ca3 = rs.getInt("ca3");
				int ca4 = rs.getInt("ca4");
				int ca5 = rs.getInt("ca5");
				int ca6 = rs.getInt("ca6");
				int ca7 = rs.getInt("ca7");
				int ca8 = rs.getInt("ca8");
				int ca9 = rs.getInt("ca9");
				int ca10 = rs.getInt("ca10");

				CorrectAnsDTO dto = new CorrectAnsDTO(ca1, ca2, ca3, ca4, ca5, ca6, ca7, ca8, ca9, ca10);
				c_list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("정답불러오기 에러");
		} finally {
			dbClose();
		}
		return c_list;
	}

>>>>>>> ChaMinHwan
	public ArrayList<UserDTO> OXOX(String id) { // 사용자 점수???

		ArrayList<OmrDTO> m = myAns(id); // n+1
		ArrayList<CorrectAnsDTO> c = CorrectAns();// n

		conn = getConn();
		ArrayList<UserDTO> ox_list = new ArrayList<>();

		try {
			for (int i = 0; i < CorrectAns().size(); i++) {

				if (m.get(i + 1).equals(c.get(i))) {
					String ox = "O";
					UserDTO dto = new UserDTO(ox);
					ox_list.add(dto);
				} else {
					String ox = "X";
					UserDTO dto = new UserDTO(ox);
					ox_list.add(dto);
				}

			}

		} catch (Exception e) {
			System.out.println("OXOX에러");
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return ox_list;
	}

	public int addTester(String id, String name) {
		conn = getConn();
		String sql = "insert into user_c (id, name) values (?, ?)";
		int succ = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, name);
			succ = ps.executeUpdate();
		} catch (Exception e) {
<<<<<<< HEAD
			e.printStackTrace();
			System.out.println("dao.addTester 에러임 ㅋㅋㅋ");
=======
>>>>>>> ChaMinHwan
		} finally {
			dbClose();
		}
		return succ;
	}

<<<<<<< HEAD
	public int removeTester(String id) { // DELETE FROM Table1 WHERE ID = 'testId';
		conn = getConn();
		String sql = "delete from user_c where id=?";
=======
	public int removeTester(String id, String name) { // DELETE FROM Table1 WHERE ID = 'testId';
		conn = getConn();
		String sql = "delete from user_c where id=?and?";
>>>>>>> ChaMinHwan
		int succ = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
<<<<<<< HEAD
			//ps.setString(2, name);
=======
			ps.setString(2, name);
>>>>>>> ChaMinHwan
			succ = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("리무브테스터 에러");
		} finally {
			dbClose();
		}
		return succ;

	}

	public int editTester(String id, String name) { // UPDATE Temp_Table SET field3='변경된 값' WHERE field1 = 'data2';
		conn = getConn();
<<<<<<< HEAD
		String sql = "업데이트 테이블";
=======
		String sql = "insert into user_c (id, name) values (?, ?)";
>>>>>>> ChaMinHwan
		int succ = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, name);
			succ = ps.executeUpdate();
		} catch (Exception e) {
		} finally {
			dbClose();
		}
		return succ;

	}

	public ArrayList<UserDTO> passFail() {
		ArrayList<UserDTO> pf_list = new ArrayList<>();
		conn = getConn();
		String sql = "select * from user_c";

		try {

			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserDTO dto = new UserDTO();
				dto.setName(rs.getString("name"));
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				pf_list.add(dto);
			}
		} catch (Exception e) {

		} finally {
			dbClose();
		}
		return pf_list;
	}
<<<<<<< HEAD

	public boolean checkId(UserDTO dto) {
		conn = getConn(); // DB접속
		String sql = "select count(*) cnt from user_c where id = ?"; // SQL 문장 작성
		try {
			ps = conn.prepareStatement(sql); // 전송객체생성
			ps.setString(1, dto.getId()); // 매개변수 값을 세팅
			rs = ps.executeQuery(); // SQL문장 실행 : select → ResultSet 결과객체 생성
			while (rs.next()) {
				if (rs.getInt("cnt") > 0) { // if문 작성 : count(*)의 값이 0보다 큰지 비교
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("checkId() Exception!!!");
		} finally {
			dbClose(); // DB접속 해제
		}
		return false; // 결과값을 리턴
	}

	public ArrayList<UserDTO> displayTester() {
		ArrayList<UserDTO> list = new ArrayList<>();
		conn = getConn();
		String sql = "select * from user_c where id != '9999'";

		try {

			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserDTO dto = new UserDTO();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setScore(rs.getInt("score"));
				dto.setOx(rs.getString("ox"));
				dto.setPass(rs.getString("pass"));
				dto.setCnt(rs.getInt("cnt"));
				list.add(dto);

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("디스플레이 테스터 에러");
		} finally {
			dbClose();
		}

		return list;
	}

	public int checkAdmin() {
		conn = getConn();
		int succ = 0;
		String sql = "select * from user_c where id = '9999'";
		try {
			ps = conn.prepareStatement(sql); // 전송객체생성
			// ps.setString(1, dto.getId()); //매개변수 값을 세팅
			rs = ps.executeQuery(); // SQL문장 실행 : select → ResultSet 결과객체 생성
			while (rs.next()) {
				succ = Integer.parseInt(rs.getString("id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("checkAdmin() Exception!!!");
		} finally {
			dbClose(); // DB접속 해제
		}
		return succ;
	}// checkAdmin()
=======
>>>>>>> ChaMinHwan
	/*
	 * 수정할 것!! public ArrayList<OmrDTO> omrSearchAll() { conn = getConn(); //DB접속
	 * String sql = "select * from answer_c"; //SQL 문장 작성 ArrayList<OmrDTO> list =
	 * new ArrayList<>(); //최종결과를 저장할 컬렉션 자료구조를 생성 try { ps =
	 * conn.prepareStatement(sql); //전송객체 생성 rs = ps.executeQuery(); //SQL문장 실행 :
	 * select → ResultSet 결과객체 생성 while(rs.next()) { DTO 클래스의 초기화된 생성자 메소드를 이용하여 DTO
	 * 객체를 생성하는 방법 String name = rs.getString("name"); String id =
	 * rs.getString("id"); String pw = rs.getString("pw"); int age =
	 * rs.getInt("age"); String addr = rs.getString("addr"); String tel =
	 * rs.getString("tel"); MemberDTO dto = new MemberDTO(name, id, pw, age, addr,
	 * tel);
	 * 
	 * 
	 * //디폴트 생성자 메소드를 이용하여 DTO 객체를 생성하는 방법 OmrDTO dto = new OmrDTO();
	 * dto.(rs.getString("name")); dto.setId(rs.getString("id"));
	 * dto.setPw(rs.getString("pw")); dto.setAge(rs.getInt("age"));
	 * dto.setAddr(rs.getString("addr")); dto.setTel(rs.getString("tel"));
	 * 
	 * list.add(dto); } } catch (Exception e) { e.printStackTrace(); //예외 발생 시 상세하게
	 * 예외 메세지를 콘솔창에 출력 System.out.println("memberSearchAll() Exception!!!"); //예외
	 * 메세지를 직접 작성하여 출력 } finally { dbClose(); //DB접속해제 } return list; //결과를 리턴
	 * }//memberSearchAll()
	 */

}
