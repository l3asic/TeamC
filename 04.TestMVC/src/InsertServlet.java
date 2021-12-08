

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanul.study.BookDAO;
import com.hanul.study.BookDTO;



@WebServlet("/is.do")
public class InsertServlet extends HttpServlet {
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
			
			int check = dao.checkIsbn(dto);						 
			if(check>0) {	//if(isbn 중복체크)
				out.println("<script>alert('isbn중복!!!'); location.href='bookMain.html';</script>");
			}else {
				int succ = dao.insertBook(dto);
				if(succ > 0) {	// if(도서 등록 성공여부)
					out.println("<link rel=\"stylesheet\" href=\"css/style.css\" />");
					out.println("<script>alert('도서등록 성공!!');</script>"); 
					out.println("<div class='iwrap'>");
					out.println("<div class='lwrap'>");
					out.println("<a href='bookMain.html'>도서정보 입력하기</a>");
					out.println("<br><br/>");
					out.println("<a href='gals.do'>전체도서 정보보기</a>");    
					out.println("</div>");
					out.println("</div>");
				}else {
					out.println("<link rel=\"stylesheet\" href=\"css/style.css\" />");
					out.println("<script>alert('도서등록 실패!!');</script>"); 
					out.println("<div class='iwrap'>");
					out.println("<div class='lwrap'>");
					out.println("<a href='bookMain.html'>도서정보 입력하기</a>");
					out.println("<br><br/>");
					out.println("<a href='gals.do'>전체도서 정보보기</a>");	
					out.println("</div>");
					out.println("</div>");
				}				
			}//중복체크 끝
			
			
			
			
			
			
			
			
			
	}

}
