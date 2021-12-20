package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.oreilly.servlet.MultipartRequest;

import dto.UserDTO;

/**
 * Servlet implementation class Ex02_DtoListGson
 */
@WebServlet("*.and")
public class Ex02_DtoListGson extends HttpServlet {
	Gson gson = new Gson();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Ex02_111111ㅋㅋㅋ");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		req.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();
		System.out.println(req.getServletPath());
		if (req.getServletPath().equals("/dto.and")) {
			MultipartRequest multi = new MultipartRequest(req, req.getRealPath("/"), 3000000);
			String fromAnd = multi.getParameter("dto");
			UserDTO fromDto = gson.fromJson(fromAnd, UserDTO.class);
			System.out.println(fromDto.getUser_id() + "안드에서 보내준값.");
			UserDTO dto = new UserDTO(1, "servlet", "servletController");
			String data = gson.toJson(dto);
			out.println(data);
		} else if (req.getServletPath().equals("/list.and")) {
			System.out.println("list");
			MultipartRequest multi = new MultipartRequest(req, req.getRealPath("/"), 3000000);
			String data = multi.getParameter("dto");
			System.out.println(data);

			ArrayList<UserDTO> list = gson.fromJson(data, new TypeToken<List<UserDTO>>() {
			}.getType());
			for (int i = 0; i < list.size(); i++) {
				list.get(i).setRefid(i + 10);
				list.get(i).setUser_id("b" + i);
				list.get(i).setUser_msg("c" + i);
			}
			String rtnData = gson.toJson(list); // String 형태의 json구조로 다시 만듬.
			out.print(rtnData);// = > InputStream is에 담아짐(Anroid)
			// json => print( data )
			// dto => servlet(Controller) 으로 보내는 처리 and=>servlet
			// list=> and => Controller => DB => and ※※※※
		}

	}

}
