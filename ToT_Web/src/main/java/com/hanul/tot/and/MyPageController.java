package com.hanul.tot.and;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

import chaminhwan.board.BoardPage;
import chaminhwan.board.BoardServiceImpl;
import chaminhwan.board.BoardVO;
import common.CommonService;
import common.chaminhwan;

@Controller
public class MyPageController {

	private static final Logger logger = LoggerFactory.getLogger(MyPageController.class);
//
//	@Autowired(required = true)
//	private BoardServiceImpl boardServiceImpl;
//
//	@Autowired(required = true)
//	private BoardPage page;

//	@Autowired(required = true)
//	private BoardVO boardVO;

//	@Autowired
//	private CommonService common;
	Gson gson = new Gson();
	@Autowired
	@Qualifier("cteam")
	SqlSession sql;

	@RequestMapping("/mypage_{member_id}")
	public String myPage(@PathVariable String member_id, Locale locale, HttpSession session, Model model,
			HttpServletRequest req) throws IOException {
		String path = req.getServletPath();

		model.addAttribute("path", "/mypage_");
		model.addAttribute("member_id", member_id);
		return "zzchaminhwan04board/board_00_main";
		// return "zzchaminhwan00mypage/mypage_00_main";
	}

	@RequestMapping("/mypage_list_*")
	public String list(BoardVO vo, Locale locale, HttpSession session, Model model, HttpServletRequest req)
			throws IOException {
		String path = req.getServletPath();

		List<BoardVO> list = sql.selectList("mypage.mapper." + path, vo);

		model.addAttribute("boardVO", list);
		return "zzchaminhwan00mypage/mypage_00_list_stack";
	}
//======================================================================================================================
}
