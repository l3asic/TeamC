package com.hanul.tot.and;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

import android.chaminhwan.MbtiVO;
import android.mainburger.MainBurgerNoticeVO;
import common.TempDAO;

@Controller
public class MbtiController {
	Gson gson = new Gson();

	@Autowired
	@Qualifier("cteam")
	private SqlSession sql;

	int i = 0;

	@RequestMapping("/android/cmh/mbti/")
	public void mbtiMatch(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws IOException {
		i++;
		String path = req.getServletPath();
		System.out.println("\n 테스트 : " + i + "\n" + path);
		System.out.println("getServletPath : " + path);

		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();

		MbtiVO vo = new MbtiVO();
		vo = gson.fromJson(req.getParameter("mbtiVO"), MbtiVO.class);
		System.out.println(vo);

		try {
			List<MainBurgerNoticeVO> list = sql.selectList("mbti.mapper.beforecompare");

		//	TempDAO dao = new TempDAO();
		//	list = dao.mbtiMatch(list);

			writer.print(gson.toJson(list));

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
