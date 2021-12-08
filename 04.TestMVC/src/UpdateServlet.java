

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanul.study.BookDAO;
import com.hanul.study.BookDTO;


@WebServlet("/us.do")
public class UpdateServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
				
		BookDTO dto = new BookDTO();
		dto.setTitle(request.getParameter("title"));
		dto.setName(request.getParameter("name"));
		dto.setIsbn(request.getParameter("isbn"));
		dto.setComp(request.getParameter("comp"));
		dto.setCost(Integer.parseInt(request.getParameter("cost")));
		dto.setQty(Integer.parseInt(request.getParameter("qty")));
		dto.setPrice(dto.getPrice());
		
		BookDAO dao = new BookDAO();
		
		response.setContentType("text/html; charset=utf-8");		
		PrintWriter out = response.getWriter();	
		int check = dao.checkIsbn(dto);							//중복 체크후 없으면 삽입실행, 
		if(check==0) {
			out.println("<script>alert('isbn이 일치 하지 않습니다!!!'); location.href='updateBook.html';</script>");
		}else {
			int succ = dao.updateBook(dto);			
			if(succ > 0) {
				out.println("<link rel=\"stylesheet\" href=\"css/style.css\" />");
				out.println("<script>alert('도서수정 성공!');</script>"); //알림창은 alert, 큰따옴표로 묶고있으니 안은 작은따옴표로 묶기사용
				out.println("<div class='uwrap'>");
				out.println("<div class='lwrap2'>");
				out.println("<a href='bookMain.html'>도서정보 입력하기</a>");
				out.println("<br><br/>");
				out.println("<a href='gals.do'>전체도서 정보보기</a>"); 
				out.println("</div>");
				out.println("</div>");
				
			}else {
				out.println("<link rel=\"stylesheet\" href=\"css/style.css\" />");
				out.println("<script>alert('도서수정 실패!!');</script>");
				out.println("<div class='uwrap2'>");
				out.println("<div class='lwrap2'>");
				out.println("<a href='bookMain.html'>도서정보 입력하기</a>");
				out.println("<br><br/>");
				out.println("<a href='gals.do'>전체도서 정보보기</a>");
				out.println("</div>");
				out.println("</div>");
			}				
		}//중복체크 끝
		
		
		
		
		
		
		
	}

}
