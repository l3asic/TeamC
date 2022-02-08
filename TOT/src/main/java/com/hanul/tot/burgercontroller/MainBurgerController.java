package com.hanul.tot.burgercontroller;

import java.io.IOException;
import java.io.PrintWriter;
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

import com.google.gson.Gson;

@Controller
public class MainBurgerController {
	/**
	 * 객체화구간
	 */
	Gson gson = new Gson();
	
// vo = new vo
//	@Autowired
//	@Autowired
//	@Autowired

	@Qualifier("hanul")
	private SqlSession sql;

//	private static final Logger logger = LoggerFactory.getLogger(AndTestController.class);

	/**
	 * 이 밑으로부터 코드작성
	 */
	@RequestMapping(value = "/android/cmh/test", method = RequestMethod.GET)
	public String home(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws IOException {
		System.out.println("android/cmh/test");
		
		
//		logger.info("Welcome home! The client locale is {}.", locale);

		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");

		
//		이걸 안드로이드에서 가져감
		PrintWriter writer = res.getWriter();
		writer.print(gson.toJson("Test Text zz"));
		writer.print("asdf");
		
		
		
		
		return "android/cmh/test";
	}

}
