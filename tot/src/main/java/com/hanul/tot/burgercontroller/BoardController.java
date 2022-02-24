package com.hanul.tot.burgercontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.management.QueryEval;
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
import org.springframework.web.client.HttpClientErrorException.Gone;

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
	public void selectList(HttpServletRequest req, HttpServletResponse res, HttpSession session, Model model)
			throws IOException {
		i++;
		String path = req.getServletPath();
		System.out.println("\n 보드컨트롤러 : " + i + "\n" + "localhost/tot" + path);
		System.out.println("getServletPath : " + path);

		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();
//======================================================================
		if (path.equals("/android/cmh/reply_select/")) {
			int paramSn = Integer.parseInt(req.getParameter("paramSn"));
			List<ReplyVO> list = new ArrayList<ReplyVO>();
			list = sql.selectList("board.mapper.board_reply_list", paramSn);
			System.out.println(list);
			writer.print(gson.toJson(list));
		} else if (path.equals("/android/cmh/reply_insert/")) {
			ReplyVO replyVO = new ReplyVO();
			replyVO = gson.fromJson(req.getParameter("replyVO"), ReplyVO.class );
			int succ = 0;
			succ = sql.insert("board.mapper.reply_insert", replyVO);
			System.out.println(succ);
			writer.print(succ);
		}
	}

	@RequestMapping("/android/cmh/whosePage_*/")
	public void selectWhoseList(HttpServletRequest req, HttpServletResponse res, HttpSession session, Model model)
			throws IOException {
		i++;
		String path = req.getServletPath();
		System.out.println("\n 보드컨트롤러 : " + i + "\n" + "localhost/tot" + path);
		System.out.println("getServletPath : " + path);

		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();

		BoardCommonVO vo = gson.fromJson(req.getParameter("vo"), BoardCommonVO.class);
		String query = "temp";

		if (path.equals("/android/cmh/whosePage_write/")) {
			query = "write";
		} else if (path.equals("/android/cmh/whosePage_likes/")) {
			query = "likes";
		}
		
		if(query.equals("temp")) {
			System.out.println("\n"+path + " : 확인 필요\n");
			query = null;
		}
		List<BoardCommonVO> list = sql.selectList("board.mapper.whose_board_" + query, vo);
		writer.print(gson.toJson(list));
	}
	
	@RequestMapping("/android/cmh/board_insert/")
	public void boardInsert(HttpServletRequest req, HttpServletResponse res, HttpSession session, Model model)
			throws IOException {
printPath(req);

		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();
	}
	
	/* =================== 게시물 삭제 ===================== */	
	@RequestMapping("/android/cmh/board_delete/")
	public void bonardDelete(HttpServletRequest req, HttpServletResponse res, HttpSession session, Model model)
			throws IOException {
		printPath(req);

		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();
		
		int board_sn = Integer.parseInt(req.getParameter("boardSN"));
		int succ = sql.delete("board.mapper.board_delete",board_sn);
		System.out.println("\nsql.delete 결과 : "+succ+"\n");
		writer.print(succ);
		
		
	}/* =================== 게시물 삭제 ===================== */
	
	
	public void printPath(HttpServletRequest req) {
		i++;
		String path = req.getServletPath();
		System.out.println("\n 보드컨트롤러 : " + i + "\n" + "localhost/tot" + path);
		System.out.println("getServletPath : " + path);
	}
}
