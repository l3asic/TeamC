package com.hanul.tot.and;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;

import com.google.gson.Gson;


import category.CategoryDAO;
import category.CategoryVO;
import common.CommonService;
import common.chaminhwan;
import category.PictureVO;
import chaminhwan.board.BoardPage;
import chaminhwan.board.BoardServiceImpl;
import chaminhwan.board.BoardVO;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired(required = true)
	private BoardServiceImpl boardServiceImpl;
	
	@Autowired(required = true)
	private BoardPage page;
	
//	@Autowired(required = true)
//	private BoardVO boardVO;
	
	@Autowired
	private CommonService common;
	
	Gson gson = new Gson();


	@RequestMapping("/board_*")
	public String board(Locale locale, HttpSession session, Model model)
			throws IOException {
		logger.info((chaminhwan.cnt++) + " =>=> " + "Welcome home! The client locale is {}.", locale);

		session.setAttribute("category", "bo");

		// DB에서 방명록 정보를 조회해와 목록화면에 출력
//		page.setCurPage(curPage); // 현재 페이지 정보를 page에 담음
//		page.setSearch(search); // 검색 조건 값을 page에 담음
//		page.setKeyword(keyword); // 검색 키워드 값을 page에 담음
//		page.setPageList(pageList); // 페이지당 보여질 글 목록 수를 page에 담음
//		page.setViewType(viewType); // 게시판 형태를 page에 담음
		BoardVO boardVO = new BoardVO();
		boardVO.setBoard_class("notice");
		boardVO.setList_cnt_many(20);
//		model.addAttribute("boardVO", boardServiceImpl.board_list(boardVO));
		
		List<BoardVO> list = boardServiceImpl.board_list(boardVO);
		model.addAttribute("boardVO",list);
		
		return "zzchaminhwan04board/board_00_main";
//		return "home";
	}

}
