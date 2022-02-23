package com.hanul.tot.and;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.text.DateFormat;
import java.util.Date;
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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import android.kwk.MemberVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	Gson gson = new Gson();

	@Autowired
	@Qualifier("cteam")
	private SqlSession sql;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpSession session, Locale locale, Model model) {
		System.out.println("HomeController 테스트");
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/test")
	public String test(HttpSession session, HttpServletRequest req) {
		System.out.println("asdfasdf");
		System.out.println();
		return "home";
	}
	
	@RequestMapping("/and/test")
	public String testand(HttpSession session) {
		return "android/test";
	}
	
	@ResponseBody
	   @RequestMapping("/login")
	   public void join(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws IOException {
	      req.setCharacterEncoding("UTF-8");
	      res.setCharacterEncoding("UTF-8");
	      res.setContentType("text/html");
	      PrintWriter writer = res.getWriter();
	      System.out.println("로그인");
	      
	      String getJson  = req.getParameter("dto");
	      
	      MemberVO vo = new MemberVO();
	      vo = gson.fromJson(getJson, MemberVO.class);
	      //vo.setMember_id("11");
	      //vo.setMember_pw("11");
	      vo  = sql.selectOne("login.mapper.login", vo);
	      
	      String temp = gson.toJson(vo);
	      System.out.println(temp);
	      writer.print(temp);
	   
	   }
	
}
