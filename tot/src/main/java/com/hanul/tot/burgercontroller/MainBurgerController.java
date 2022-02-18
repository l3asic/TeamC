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

import android.mainburger.BoardCommonVO;

@Controller
public class MainBurgerController {
	Gson gson = new Gson();

	@Autowired
	@Qualifier("cteam")
	private SqlSession sql;

	int i = 0;

//http://localhost/tot/android/cmh/board_list@board_class=notice/view_cnt=10/
//notice recommand where tour
// * : /로 분리가능 읭 정렬기준 추가 가능.
	@RequestMapping("/android/cmh/board_list")
	public void selectList(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws IOException {
		i++;
		String path = req.getServletPath();
		System.out.println("\n 테스트 : " + i + "\n" + "localhost/tot" + path);
		System.out.println("getServletPath : " + path);

		BoardCommonVO vo = new BoardCommonVO();
		vo = gson.fromJson(req.getParameter("vo"), BoardCommonVO.class);
		System.out.println("board_class = " + vo.getBoard_class());
		System.out.println("list_cnt_many = " + vo.getList_cnt_many());
		System.out.println();

		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");

		PrintWriter writer = res.getWriter();

		List<BoardCommonVO> list = new ArrayList<BoardCommonVO>();
		/*
		 * vo.setBoard_class(req.getParameter("board_class")+""); list =
		 * sql.selectList("mainburgernotice.mapper.noticelist",vo);
		 */
		list = sql.selectList("mainburger.mapper.board_list", vo);

//		이걸 안드로이드에서 가져감
		writer.print(gson.toJson(list));
		// sql.close(); 여기 오류
		System.out.println();

	}

	@RequestMapping("/android/cmh/board_list@*/*/")
	public void noticeList(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws IOException {
		i++;
		String path = req.getServletPath();
System.out.println("\n\n board_list@*/*/ \n\n");
System.out.println("\n\n board_list@*/*/ \n\n");
System.out.println("\n\n board_list@*/*/ \n\n");
		System.out.println("\n 테스트 : " + i + "\n" + "localhost/tot" + path);
		System.out.println("getServletPath : " + path);

		int idx = path.indexOf("@");
		String afterSub = path.substring(idx + 1);
		System.out.println("afterSub : " + afterSub);

		String[] paramCnt = afterSub.split("/");
		BoardCommonVO vo = new BoardCommonVO();
		// vo =gson.fromJson(req.getParameter("vo"), MainBurgerNoticeVO.class) ;
		System.out.println("paramCnt.length : " + paramCnt.length);

		idx = paramCnt[0].indexOf("=");
		vo.setBoard_class(paramCnt[0].substring(idx + 1));
		System.out.println("실제값 : " + vo.getBoard_class());
		idx = paramCnt[1].indexOf("=");
		vo.setList_cnt_many(Integer.parseInt(paramCnt[1].substring(idx + 1)));
		System.out.println("실제값 : " + vo.getList_cnt_many());
		System.out.println();
		System.out.println("board_class = " + vo.getBoard_class());
		System.out.println("list_cnt_many = " + vo.getList_cnt_many());
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();

		List<BoardCommonVO> list = new ArrayList<BoardCommonVO>();
		/*
		 * vo.setBoard_class(req.getParameter("board_class")+""); list =
		 * sql.selectList("mainburgernotice.mapper.noticelist",vo);
		 */
		list = sql.selectList("mainburger.mapper.board_list", vo);

//		이걸 안드로이드에서 가져감
		writer.print(gson.toJson(list));

	}

	@RequestMapping("/android/cmh/board_detail@*/")
	public void notice_detail(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws IOException {
		i++;
		String path = req.getServletPath();
		System.out.println("\n" + "getServletPath : " + path + " : " + i);

		int idx = path.indexOf("@");
		String afterSub = path.substring(idx + 1);
		System.out.println("afterSub : " + afterSub);

		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();

		BoardCommonVO vo = new BoardCommonVO();
		System.out.println(req.getParameter("paramSn") + " 게시물 조회 ");
		int paramSn = Integer.parseInt(req.getParameter("paramSn"));

		vo = sql.selectOne("mainburger.mapper.board_detail", paramSn);

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

		BoardCommonVO vo = new BoardCommonVO();

		String getVo = req.getParameter("vo");
		vo = gson.fromJson(getVo, BoardCommonVO.class);

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
