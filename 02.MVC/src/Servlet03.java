import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanul.study.MemberDAO;
import com.hanul.study.MemberDTO;

@WebServlet("/s03.do")
public class Servlet03 extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		//① 클라이언트의 요청을 받는다 : 폼에서 입력한 매개변수를 가져온다.
		request.setCharacterEncoding("utf-8");	//인코딩 설정
		/* DTO 클래스의 초기화된 생성자 메소드를 이용하여 DTO 객체를 생성하는 방법
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		int age = Integer.parseInt(request.getParameter("age"));
		String addr = request.getParameter("addr");
		String tel = request.getParameter("tel");
		MemberDTO dto = new MemberDTO(name, id, pw, age, addr, tel);
		*/
		//디폴트 생성자 메소드를 이용하여 DTO 객체를 생성하는 방법
		MemberDTO dto = new MemberDTO();
		dto.setName(request.getParameter("name"));
		dto.setId(request.getParameter("id"));
		dto.setPw(request.getParameter("pw"));
		dto.setAge(Integer.parseInt(request.getParameter("age")));
		dto.setAddr(request.getParameter("addr"));
		dto.setTel(request.getParameter("tel"));
		
		//② 비지니스 로직 : DAO 클래스를 통해서 DataBase 연동
		MemberDAO dao = new MemberDAO();
		int succ = dao.memberInsert(dto);
		
		//③ 프리젠테이션 로직 : 결과를 응답(html, jsp)
		response.setContentType("text/html; charset=utf-8");	//MIME Type
		PrintWriter out = response.getWriter();		//출력스트림
		if(succ > 0) {
			out.println("<script>alert('회원가입 성공!!!');</script>");
			out.println("<a href='memberMain.html'>회원가입 화면으로 이동</a>");
			out.println("<br/><br/>");
			out.println("<a href='s04.do'>전체회원 목록보기</a>");
		}else {
			out.println("<script>alert('회원가입 실패!!!');</script>");
			out.println("<a href='memberMain.html'>회원가입 화면으로 이동</a>");
			out.println("<br/><br/>");
			out.println("<a href='s04.do'>전체회원 목록보기</a>");
		}		
	}
}//class






