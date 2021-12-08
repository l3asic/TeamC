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

	public ArrayList<UserDTO> markQna() { // XXXXX
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
			ps.setString(2, dto.getAnswer1());
			ps.setString(3, dto.getAnswer2());
			ps.setString(4, dto.getAnswer3());
			ps.setString(5, dto.getAnswer4());
			ps.setString(6, dto.getAnswer5());
			ps.setString(7, dto.getAnswer6());
			ps.setString(8, dto.getAnswer7());
			ps.setString(9, dto.getAnswer8());
			ps.setString(10, dto.getAnswer9());
			ps.setString(11, dto.getAnswer10());
			succ = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("insertAnswer() Exception!!!");
		} finally {
			dbClose();
		}
		return succ;
	}// deleteOmr()

	public int deleteOmr(String id) { // answer_c 테이블 컬럼삭제
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

	public ArrayList<CorrectAnsDTO> CorrectAns() { // 정답 리스트
		conn = getConn();
		String sql = "select * from correctanswer_C";
		ArrayList<CorrectAnsDTO> c_list = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				String ca1 = rs.getString("ca1");
				String ca2 = rs.getString("ca2");
				String ca3 = rs.getString("ca3");
				String ca4 = rs.getString("ca4");
				String ca5 = rs.getString("ca5");
				String ca6 = rs.getString("ca6");
				String ca7 = rs.getString("ca7");
				String ca8 = rs.getString("ca8");
				String ca9 = rs.getString("ca9");
				String ca10 = rs.getString("ca10");

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
		String sql = "select * from answer_c where id = ?";
		ArrayList<OmrDTO> m_list = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				String answer1 = rs.getString("answer1");
				String answer2 = rs.getString("answer2");
				String answer3 = rs.getString("answer3");
				String answer4 = rs.getString("answer4");
				String answer5 = rs.getString("answer5");
				String answer6 = rs.getString("answer6");
				String answer7 = rs.getString("answer7");
				String answer8 = rs.getString("answer8");
				String answer9 = rs.getString("answer9");
				String answer10 = rs.getString("answer10");

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

	public OmrDTO OXOX(String id) { // 사용자 점수???

		ArrayList<OmrDTO> m = myAns(id); // n+1
		ArrayList<CorrectAnsDTO> c = CorrectAns();// n

		conn = getConn();
//		ArrayList<OmrDTO> ox_list = new ArrayList<>();
		OmrDTO ox_list = new OmrDTO();

		try {
			for (int i = 0; i < CorrectAns().size(); i++) {

				if (m.get(i).answer1.equals(c.get(i).ca1)) { // 엘리먼트 잘 읽어주세요 ;ㅅ;
					ox_list.setAnswer1("O"); // 정답이면 int 1
				} else {
					ox_list.setAnswer1("X"); // 오답이면 int 0
				}

				if (m.get(i).answer2.equals(c.get(i).ca2)) { // 엘리먼트 잘 읽어주세요 ;ㅅ;
					ox_list.setAnswer2("O"); // 정답이면 int 1
				} else {
					ox_list.setAnswer2("X"); // 오답이면 int 0
				}

				if (m.get(i).answer3.equals(c.get(i).ca3)) { // 엘리먼트 잘 읽어주세요 ;ㅅ;
					ox_list.setAnswer3("O"); // 정답이면 int 1
				} else {
					ox_list.setAnswer3("X"); // 오답이면 int 0
				}

				if (m.get(i).answer4.equals(c.get(i).ca4)) { // 엘리먼트 잘 읽어주세요 ;ㅅ;
					ox_list.setAnswer4("O"); // 정답이면 int 1
				} else {
					ox_list.setAnswer4("X"); // 오답이면 int 0
				}

				if (m.get(i).answer5.equals(c.get(i).ca5)) { // 엘리먼트 잘 읽어주세요 ;ㅅ;
					ox_list.setAnswer5("O"); // 정답이면 int 1
				} else {
					ox_list.setAnswer5("X"); // 오답이면 int 0
				}

				if (m.get(i).answer6.equals(c.get(i).ca6)) { // 엘리먼트 잘 읽어주세요 ;ㅅ;
					ox_list.setAnswer6("O"); // 정답이면 int 1
				} else {
					ox_list.setAnswer6("X"); // 오답이면 int 0
				}

				if (m.get(i).answer7.equals(c.get(i).ca7)) { // 엘리먼트 잘 읽어주세요 ;ㅅ;
					ox_list.setAnswer7("O"); // 정답이면 int 1
				} else {
					ox_list.setAnswer7("X"); // 오답이면 int 0
				}

				if (m.get(i).answer8.equals(c.get(i).ca8)) { // 엘리먼트 잘 읽어주세요 ;ㅅ;
					ox_list.setAnswer8("O"); // 정답이면 int 1
				} else {
					ox_list.setAnswer8("X"); // 오답이면 int 0
				}

				if (m.get(i).answer9.equals(c.get(i).ca9)) { // 엘리먼트 잘 읽어주세요 ;ㅅ;
					ox_list.setAnswer9("O"); // 정답이면 int 1
				} else {
					ox_list.setAnswer9("X"); // 오답이면 int 0
				}

				if (m.get(i).answer10.equals(c.get(i).ca10)) { // 엘리먼트 잘 읽어주세요 ;ㅅ;
					ox_list.setAnswer10("O"); // 정답이면 int 1
				} else {
					ox_list.setAnswer10("X"); // 오답이면 int 0
				}

				String answer1 = ox_list.getAnswer1();
				String answer2 = ox_list.getAnswer2();
				String answer3 = ox_list.getAnswer3();
				String answer4 = ox_list.getAnswer4();
				String answer5 = ox_list.getAnswer5();
				String answer6 = ox_list.getAnswer6();
				String answer7 = ox_list.getAnswer7();
				String answer8 = ox_list.getAnswer8();
				String answer9 = ox_list.getAnswer9();
				String answer10 = ox_list.getAnswer10();

//				System.out.println(answer1);
//				System.out.println(answer2);
//				System.out.println(answer3);
//				System.out.println(answer4);
//				System.out.println(answer5);
//				if (m.get(i + 1).equals(c.get(i))) {
//					String ox = "O";
//					OmrDTO dto = new OmrDTO();
//				} else {
//					String ox = "X";
//					OmrDTO dto = new OmrDTO();
//				}
//				System.out.println(i + "번재반복ㅋㅋ");
//				System.out.println(i + "번재반복ㅋㅋ");
//				System.out.println("ㅁㅁㅁㅁㅁㅁㅁㅁㅁ");
//				System.out.println(CorrectAns().size());
//				System.out.println(CorrectAns().size());
//				System.out.println(CorrectAns().size());
//				System.out.println("ㅁㅁㅁㅁㅁㅁㅁㅁㅁ");
//				System.out.println(i + "번재반복ㅋㅋ");
//				System.out.println(i + "번재반복ㅋㅋ");
//
//			}
				ox_list = new OmrDTO(id, answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8,
						answer9, answer10);
//				ox_list.add(dto);
			}
		} catch (Exception e) {
			System.out.println("OXOX에러 프린트스택트레이스주석해놧음");
			System.out.println("OXOX에러 프린트스택트레이스주석해놧음");
//			e.printStackTrace();
		} finally {
			dbClose();
		}
		return ox_list;
	}

	public int addTester(String id, String name) { // user_c 테이블 insert into
		conn = getConn();
		String sql = "insert into user_c (id, name) values (?, ?)";
		int succ = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, name);
			succ = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("dao.addTester 에러임 ㅋㅋㅋ");
		} finally {
			dbClose();
		}
		return succ;
	}

	public int removeTester(String id) { // DELETE FROM Table1 WHERE ID = 'testId';
		conn = getConn();
		String sql = "delete from user_c where id=?";
		int succ = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
//			ps.setString(2, name);
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
		String sql = "업데이트 테이블";
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

	public ArrayList<UserDTO> passFail() { // "select * from user_c";
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

	public boolean checkId(UserDTO dto) { // select count(*) cnt from user_c where id = ?
		boolean result = false;
		conn = getConn(); // DB접속
		String sql = "select count(*) cnt from user_c where id = ?"; // SQL 문장 작성
		try {
			ps = conn.prepareStatement(sql); // 전송객체생성
			ps.setString(1, dto.getId()); // 매개변수 값을 세팅
			rs = ps.executeQuery(); // SQL문장 실행 : select → ResultSet 결과객체 생성
			while (rs.next()) {
				if (rs.getInt("cnt") > 0) { // if문 작성 : count(*)의 값이 0보다 큰지 비교
					result = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("checkId() Exception!!!");
		} finally {
			dbClose(); // DB접속 해제
		}
		return result; // 결과값을 리턴
	}

	public ArrayList<UserDTO> displayTester() { // select * from user_c where id != '9999'
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

	public int checkAdmin() { // "select * from user_c where id = '9999'"
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

	public int checkTried(String id) { // "select count(*) cnt from answer_c where id = ?
		conn = getConn();
		int succ = 0;
		String sql = "select count(*) cnt from answer_c where id = ?";
		try {
			ps = conn.prepareStatement(sql); // 전송객체생성
			ps.setString(1, id);
			// ps.setString(1, dto.getId()); //매개변수 값을 세팅
			rs = ps.executeQuery(); // SQL문장 실행 : select → ResultSet 결과객체 생성
			while (rs.next()) {
				succ = rs.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("checkAdmin() Exception!!!");
		} finally {
			dbClose(); // DB접속 해제
		}
		return succ;
	}// checkAdmin()

	public ArrayList<UserDTO> selectAll() { // "select * from user_c";
		ArrayList<UserDTO> u_list = new ArrayList<>();
		conn = getConn();
		String sql = "select * from user_c";

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserDTO dto = new UserDTO();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				u_list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("전체회원 목록조회 에러");
		} finally {
			dbClose();
		}
		return u_list;
	}

	public ArrayList<UserDTO> selectUser(String id) { // "select * from user_c where id=?";
		ArrayList<UserDTO> user_list = new ArrayList<>();
		conn = getConn();
		String sql = "select * from user_c where id=?";
		try {
			ps = conn.prepareStatement(sql);
			UserDTO dto = new UserDTO();
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setScore(rs.getInt("score"));
				dto.setOx(rs.getString("ox"));
				dto.setPass(rs.getString("pass"));
				dto.setCnt(rs.getInt("cnt"));
				user_list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("selectUser() Exception!!!");
		} finally {
			dbClose();
		}
		return user_list;
	}// selectUser()

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
