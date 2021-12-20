package controller;

import java.awt.List;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.google.gson.Gson;

import dto.GridDTO;
import dto.UserDTO;
import oracle.net.ns.SessionAtts;

@WebServlet("*.vw")
public class Ex03_AllViewController extends HttpServlet {

	Gson gson = new Gson();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		System.out.println("==============start");
		System.out.println("req.getServletPath() = " + req.getServletPath());

		if (req.getServletPath().equals("/list.vw")) {
			selectList(req, res);
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
				java.util.List<GridDTO> list = session.selectList("org.mybatis.example.BlogMapper.abcd");
				String data = gson.toJson(list) + "\n" + "</bn>";
				PrintWriter out = res.getWriter();
				out.print(data);
				System.out.println("ㅁㅁㅁㅁ");

//				System.out.println(list.get(1).getTitle());

				for (int i = 0; i < list.size(); i++) {
					System.out.println(list.get(i).getTitle());
					System.out.println(list.get(i).getContent());
					System.out.println(list.get(i).getImgresid());

				}
				System.out.println("==============end");
				session.close();

			}
		} catch (Exception e) {

			System.out.println("initMybatis() 에러");
			e.printStackTrace();
			System.out.println("initMybatis() 에러");
		}

	}

}
