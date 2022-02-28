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
public class MbtiController2 {

	private static final Logger logger = LoggerFactory.getLogger(MbtiController2.class);
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

	@RequestMapping("/mbti_*")
	public String list(BoardVO vo, Locale locale, HttpSession session, Model model, HttpServletRequest req)
			throws IOException {
		String path = req.getServletPath();
//		int succ = sql.selectOne("member.mapper.login", vo.getMember_id());
//		if( succ > 0 ) {
		if (vo.getMember_id() == null || vo.getMember_id().equals("")) {
			System.out.println("에러페이지 연결");
			return "errorPage";
		} else {
			System.out.println(path);
			List<BoardVO> list = sql.selectList("mbti.mapper." + path, vo);
			model.addAttribute("boardVO", list);
		}
//		}else {
//		model.addAttribute("board")	
//		}

		return "zzchaminhwan/main_07_instagram_feed_list";
	}
//======================================================================================================================
}
