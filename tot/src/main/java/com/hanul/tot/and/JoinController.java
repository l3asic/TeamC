package com.hanul.tot.and;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletRequest;
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
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.google.gson.Gson;

import android.kwk.MemberVO;
import login.TendVO;

@Controller
public class JoinController {
	
	
	Gson gson = new Gson();
	
	@Autowired
	@Qualifier("cteam")
	private SqlSession sql;
	/**
	 * 이 밑으로부터 코드작성
	 */
	
	@ResponseBody
	@RequestMapping("/join")
	public void join_insert(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws IOException {
		 
		 req.setCharacterEncoding("UTF-8"); 
		 res.setCharacterEncoding("UTF-8");
		 res.setContentType("text/html"); 
		 PrintWriter writer = res.getWriter();
		 System.out.println("회원가입");
		
		  MemberVO vo = gson.fromJson(req.getParameter("vo"), MemberVO.class); 
		 String temp = req.getParameter("vo"); 
		 vo = gson.fromJson(temp, MemberVO.class);
		 sql.insert("login.mapper.join_insert", vo);
		
		 writer.print(gson.toJson(vo));
	}
	
	
	// @@@ 찾았다 넣는곳 성향 넣는곳
	@ResponseBody
	@RequestMapping("/tend_insert")
	public void tend(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws IOException {
		
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();
		System.out.println("성향분석 값 ");		
		TendVO vo = new TendVO();
		String temp =  req.getParameter("vo");
		System.out.println(temp);
		int succ = 0;
		vo = gson.fromJson(temp, TendVO.class);
		
		//succ = sql.selectOne("login.mapper.tend_check", vo);
		
		
		
		//이미 성향정보가 있다면 update
		if(sql.selectOne("login.mapper.tend_check", vo) != null) {
			succ = sql.update("login.mapper.tend_update", vo);
			
		//성향정보가 없다면 insert	
		}else {			
			succ = sql.insert("login.mapper.tend_insert", vo);
		}
				
		
		writer.print(gson.toJson(succ));
	}
	
//	@ResponseBody
//	@RequestMapping("/login")
//	public void join(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws IOException {
//		req.setCharacterEncoding("UTF-8");
//		res.setCharacterEncoding("UTF-8");
//		res.setContentType("text/html");
//		PrintWriter writer = res.getWriter();
//		System.out.println("로그인");
//		
//		String getJson  = req.getParameter("dto");
//		
//		MemberVO vo = new MemberVO();
//		vo = gson.fromJson(getJson, MemberVO.class);
//		vo  = sql.selectOne("login.mapper.login", vo);
//		
//		String temp = gson.toJson(vo);
//		System.out.println(temp);
//		writer.print(temp);
//	
//	}
	
	@ResponseBody
	@RequestMapping("/id_check")
	public void id_check(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws IOException {
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();
		System.out.println("아이디 중복확인");
		
		String getJason = req.getParameter("id");
	    int id_chk = sql.selectOne("login.mapper.id_check", getJason);
	    
	    String temp = gson.toJson(id_chk);
		System.out.println(temp);
		writer.print(temp);
		
	}
	
	@ResponseBody
	@RequestMapping("/nick_check")
	public void nick_check(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws IOException {
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();
		System.out.println("닉네임 중복확인");
		
		String getJson = req.getParameter("nick");
		int nick_chk = sql.selectOne("login.mapper.nick_check", getJson);
		
		String temp = gson.toJson(nick_chk);
		System.out.println(temp);
		writer.print(temp);
		
	
	}
	
	@ResponseBody
	@RequestMapping("/find_id")
	public void find_id(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws IOException {
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();
		System.out.println("아이디 찾기");
		
		String getJson  = req.getParameter("tel");
		
		String tel = sql.selectOne("login.mapper.find_id",getJson);
		String temp = gson.toJson(tel);
		System.out.println(temp);
		writer.print(temp);
	
	}
	
	@ResponseBody
	@RequestMapping("/find_pw")
	public void find_pw(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws IOException {
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();
		System.out.println("비밀번호 찾기");
		
		String getJson  = req.getParameter("dto");
		MemberVO vo = new MemberVO();
		vo = gson.fromJson(getJson, MemberVO.class);
		
		vo = sql.selectOne("login.mapper.find_pw",vo);
		
		String temp = gson.toJson(vo);
		System.out.println(temp);
		writer.print(temp);
	
	}
	
	
	
}
