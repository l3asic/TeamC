package com.hanul.tot.burgercontroller;

import java.io.IOException;
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

@Controller
public class MainBurgerController {
	Gson gson = new Gson();
	MainBurgerNoticeVO vo = new MainBurgerNoticeVO();
	@Autowired
	@Qualifier("cteam")
	private SqlSession sql;
	@RequestMapping("/android/cmh/test")
	public void home(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws IOException {
		System.out.println("android/cmh/test");
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();
		
		List<MainBurgerNoticeVO> list = new ArrayList<MainBurgerNoticeVO>();
		/*
		 * vo.setBoard_class(req.getParameter("board_class")+""); list =
		 * sql.selectList("mainburgernotice.mapper.noticelist",vo);
		 */
		list = sql.selectList("mainburgernotice.mapper.noticelist");

//		이걸 안드로이드에서 가져감
		writer.print(gson.toJson(list));

	}

}
