

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanul.study.BookDAO;
import com.hanul.study.BookDTO;



@WebServlet("/gals.do")
public class GetAllListServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
				BookDAO dao = new BookDAO();				
				ArrayList<BookDTO> list = dao.getAllList();
					
				response.setContentType("text/html; charset=utf-8");	
				PrintWriter out = response.getWriter();		
				
				out.println("<link rel=\"stylesheet\" href=\"css/style.css\" />");
				out.println("<body>");			
				out.println("<div class='list-book'>");
				out.println("<div class='section'>");
				out.println("<h3>전체도서 목록보기</h3>");
				out.println("<table border='1' align='center'>");
				out.println("<tr>");
				out.println("<th>도서명</th>");
				out.println("<th>저자</th>");
				out.println("<th>isbn</th>");
				out.println("<th>출판사</th>");
				out.println("<th>단가</th>");
				out.println("<th>수량</th>");		
				out.println("<th>가격</th>");
				out.println("<th>삭제</th>");					
				out.println("</tr>");
				
				if(list.size() == 0) {
					out.println("<tr align='center'>");
					out.println("<td colspan='8'>도서목록이 없습니다!</td>");
					out.println("</tr>");
				}else {
					for (BookDTO dto : list) {
						out.println("<tr align='center'>");
						out.println("<td>" + dto.getTitle() + "</td>");
						out.println("<td>" + dto.getName() + "</td>");
						out.println("<td>" + dto.getIsbn() + "</td>");
						out.println("<td>" + dto.getComp() + "</td>");
						out.println("<td>" + dto.getCost() + "</td>");
						out.println("<td>" + dto.getQty() + "</td>");
						out.println("<td>" + dto.getPrice() + "</td>");
						out.println("<td><a href='ds.do?isbn=" + dto.getIsbn() + "'>삭제</a></td>");						
						out.println("</tr>");
					}
				}
				
				BookDTO dto = new BookDTO();				
				out.println("<tr align='center'>");
				out.println("<td colspan='8'>");
				out.println("<a href='bookMain.html'>도서 정보 입력하기</a>");
				out.println("&nbsp;&nbsp;&nbsp;");
				out.println("<a href='updateBook.html'>도서 정보 수정하기</a>");			
				out.println("&nbsp;&nbsp;&nbsp;");
				out.println("<a href='das.do?'>전체도서삭제</a>");		//DeleteAllServlet 으로 전송	
				out.println("</td>");
				out.println("</tr>");
				out.println("</table>");
				out.println("</div>");
				out.println("</div>");
				out.println("</body>");
		
	}

}
