

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanul.study.BookDAO;
import com.hanul.study.BookDTO;


@WebServlet("/das.do")
public class DeleteAllServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {										//전체 도서 삭제 servlet
	
		request.setCharacterEncoding("utf-8");

		BookDAO dao = new BookDAO();
		BookDTO dto = new BookDTO();
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		int succ = dao.deleteAll(dto);		//전체삭제 메소드의 결과를 succ에 저장
		if (succ > 0) {
			out.println("<link rel=\"stylesheet\" href=\"css/style.css\" />");
			out.println("<script>alert('전체도서 삭제성공!');</script>");
			out.println("<div class='uwrap3'>");
			out.println("<div class='lwrap2'>");
			out.println("<a href='bookMain.html'>도서정보 등록화면</a>");
			out.println("<br/><br/>");
			out.println("<a href='gals.do'>도서정보 목록보기</a>");
			out.println("</div>");
			out.println("</div>");
		} else {
			out.println("<link rel=\"stylesheet\" href=\"css/style.css\" />");
			out.println("<script>alert('전체도서 삭제실패!');</script>");
			out.println("<div class='uwrap2'>");
			out.println("<div class='lwrap2'>");
			out.println("<a href='bookMain.html'>도서정보 등록화면</a>");
			out.println("<br/><br/>");
			out.println("<a href='gals.do'>도서정보 목록보기</a>");
			out.println("</div>");
			out.println("</div>");
		}
		
		
	}

}
