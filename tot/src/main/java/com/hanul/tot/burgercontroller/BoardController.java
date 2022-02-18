package com.hanul.tot.burgercontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.google.gson.Gson;

import android.chaminhwan.ReplyVO;
import android.mainburger.BoardCommonVO;

@Controller
public class BoardController {
	Gson gson = new Gson();

	@Autowired
	@Qualifier("cteam")
	private SqlSession sql;

	int i = 0;


	
	
	@RequestMapping("/android/cmh/reply_*/")
	public void selectList(HttpServletRequest req, HttpServletResponse res, HttpSession session , Model model) throws IOException {
		i++;
		String path = req.getServletPath();
		System.out.println("\n 보드컨트롤러 : " + i + "\n" + "localhost/tot" + path);
		System.out.println("getServletPath : " + path);

		int paramSn = Integer.parseInt(req.getParameter("paramSn"));

		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();

		List<ReplyVO> list = new ArrayList<ReplyVO>();
		list = sql.selectList("board.mapper.board_reply_list", paramSn);

		System.out.println(list);
		
		writer.print(gson.toJson(list));
		//model.addAttribute("andJson",gson.toJson(list));
		
		
//		model.addAttribute("andJson",list);
		
//		model.addAttribute("list",list);
		
//		return "android/print_Json";
		
	}
}
