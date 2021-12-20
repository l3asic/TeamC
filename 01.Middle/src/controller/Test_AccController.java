package controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.event.ListSelectionListener;
import javax.tools.ForwardingFileObject;
//import javax.xml.ws.Response;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//import org.omg.CORBA.Request;

import com.google.gson.Gson;
import com.oreilly.servlet.MultipartRequest;

//import action.Action;
//import action.ActionForward;
import dto.AccDTO;
import dto.GridDTO;

@WebServlet("*.acc")
public class Test_AccController extends HttpServlet {

	Gson gson = new Gson();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		req.setCharacterEncoding("utf-8");
//		res.setCharacterEncoding("utf-8");
//		res.setContentType("text/html");
//		String name;
		String uri = req.getRequestURI(); // uri-pattern 값 : /10.Member_Board/xxx.me
		String ctx = req.getContextPath(); // context root 값 : /10.Member_Board
		String command = uri.substring(ctx.length()); // 실제 요청한 페이지 : /xxx.me

		String path = req.getRealPath("/");
		System.out.println(path);
		MultipartRequest multi = new MultipartRequest(req, path, 300000);

		if (command.equals("/signOn.acc")) {
			String returnString = multi.getParameter("signOn");
			System.out.println(returnString);

			AccDTO dto = gson.fromJson(returnString, AccDTO.class);

			signOn(dto);
		} else if (command.equals("/signIn.acc")) {
			String returnString = multi.getParameter("signIn");
			System.out.println(returnString);

			AccDTO dto = gson.fromJson(returnString, AccDTO.class);
			signIn(dto);

		} else if (command.equals("/afterSignIn.acc")) {
			req.setCharacterEncoding("utf-8");
			res.setCharacterEncoding("utf-8");
			res.setContentType("text/html");

			String returnString = multi.getParameter("afterSignIn");
			System.out.println(returnString);

			AccDTO dto = gson.fromJson(returnString, AccDTO.class);
			selectList(req, res);

		}

	}

	public void signOn(AccDTO dto) {

		try {
			String resource = "mybatis/config.xml";
			InputStream inputStream;
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

			try (SqlSession session = sqlSessionFactory.openSession()) {
				int result = session.insert("org.mybatis.example.BlogMapper.SignOn", dto);
				session.commit();
				System.out.println(result);

				session.close();

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public boolean isAccounted(AccDTO dto) { // 회원가입이 돼있는지 확인
		boolean is = false;
		try {
			String resource = "mybatis/config.xml";
			InputStream inputStream;
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

			try (SqlSession session = sqlSessionFactory.openSession()) {

				int result = session.selectOne("org.mybatis.example.BlogMapper.isAccounted", dto);
				session.commit();
				System.out.println(result);
				session.close();
				if (result > 0) {
					is = true;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return is;
	}

	public void signIn(AccDTO dto) { // 아이디 and 비밀번호 일치하는지 확인 -> 있으면 로그인성공, 값을어디다 어떻게줌?
		try {
			String resource = "mybatis/config.xml";
			InputStream inputStream;
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

			try (SqlSession session = sqlSessionFactory.openSession()) {

				if (isAccounted(dto)) {

					int result = session.insert("org.mybatis.example.BlogMapper.isSignIn", dto);
					session.commit();
					System.out.println(result);
					session.close();
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void selectList(HttpServletRequest req, HttpServletResponse res) {
//		ArrayList<GridDTO> list = new ArrayList<>();

		try {
			String resource = "mybatis/config.xml";
			InputStream inputStream;
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

			try (SqlSession session = sqlSessionFactory.openSession()) {
				java.util.List<AccDTO> list = session.selectList("org.mybatis.example.BlogMapper.isAccounted");
				String data = gson.toJson(list) + "\n" + "</bn>";
				PrintWriter out = res.getWriter();
				out.print(data);

				session.close();

			}
		} catch (Exception e) {

			System.out.println("initMybatis() 에러");
			e.printStackTrace();
			System.out.println("initMybatis() 에러");
		}

	}

}
