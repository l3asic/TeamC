package com.hanul.tot.burgercontroller;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

import android.mainburger.MainBurgerNoticeVO;
import android.mainburger.OneOneEmailVO;

@Controller
public class MainBurgerController {
	Gson gson = new Gson();
	

	@Autowired
	@Qualifier("cteam")
	private SqlSession sql;

	int i = 0;

	@RequestMapping("/android/cmh/notice")
	public void noticeList(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws IOException {
		i++;
		System.out.println("테스트 : android/cmh/notice : " + i + "\n");
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();

		List<MainBurgerNoticeVO> list = new ArrayList<MainBurgerNoticeVO>();
		/*
		 * vo.setBoard_class(req.getParameter("board_class")+""); list =
		 * sql.selectList("mainburgernotice.mapper.noticelist",vo);
		 */
		list = sql.selectList("mainburger.mapper.noticelist");

//		이걸 안드로이드에서 가져감
		writer.print(gson.toJson(list));

	}

	@RequestMapping("/android/cmh/notice_detail")
	public void notice_detail(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws IOException {
		i++;
		System.out.println("테스트 : android/cmh/insertVS : " + i + "\n");
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();
		
		MainBurgerNoticeVO vo = new MainBurgerNoticeVO();
		int paramSn = Integer.parseInt(req.getParameter("paramSn"));
		
		vo = sql.selectOne("mainburger.mapper.notice_detail", paramSn);
		
		
		writer.print(gson.toJson(vo));
	}

	@RequestMapping("/android/cmh/insertVS")
	public void insertVS(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws IOException {
		i++;
		System.out.println("테스트 : android/cmh/insertVS : " + i + "\n");
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();

		OneOneEmailVO vo = new OneOneEmailVO();
		vo = (OneOneEmailVO) req.getAttribute("vo");
		
		vo.setName(vo.getName());
		vo.setTitle(vo.getTitle());
		vo.setContent(vo.getContent());
		/*
		 * vo.setBoard_class(req.getParameter("board_class")+""); list =
		 * sql.selectList("mainburgernotice.mapper.noticelist",vo);
		 */
		try {

			sql.insert("mainburger.mapper.insertVs", vo);

//			이걸 안드로이드에서 가져감
			// vo = sql.selectOne("mainburger.mapper.selectThisVs");

			writer.print(gson.toJson(vo));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
