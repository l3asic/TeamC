package com.hanul.tot.and;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

import chaminhwan.board.BoardPage;
import chaminhwan.board.BoardServiceImpl;
import chaminhwan.board.BoardVO;
import common.CommonService;
import common.chaminhwan;

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

	@RequestMapping(value = "/board_*")
	public String board(BoardVO vo, Locale locale, HttpSession session, Model model, HttpServletRequest req)
			throws IOException {
		String path = req.getServletPath();
		logger.info((chaminhwan.cnt++) + " =>=> " + "Welcome home! The client locale is {}.", locale);
		System.out.println("path : " + path);

		if (path.equals("/board_list")) {// ==================== board_list ====================
			System.out.println("진입 : list");
			// ====================
			BoardVO boardVO = new BoardVO();
			boardVO.setBoard_class("notice");
			boardVO.setList_cnt_many(999);
			List<BoardVO> list = boardServiceImpl.board_list(boardVO);

			model.addAttribute("boardVO", list);
		} else if (path.equals("/board_detail")) {// ==================== board_detail ====================
			System.out.println("진입 : detail");
			// ====================
			vo = boardServiceImpl.board_detail(vo.getBoard_sn());

			model.addAttribute("boardVO", vo);
			model.addAttribute("jsonVO", gson.toJson(vo));
		} else if (path.equals("/board_new")) {// ==================== board_new ====================
			System.out.println("진입 : new");
			// ====================

		} else if (path.equals("/board_insert")) {// ==================== board_insert ====================
			System.out.println("진입 : insert");
			// ====================
			vo.setBoard_class("user");
			vo.setMember_id("ChaMinHwan");
			boardServiceImpl.board_insert(vo);
			return "redirect:board_list";
		} else if (path.equals("/board_delete")) {
			System.out.println("진입 : delete");
			// ====================
			if (boardServiceImpl.board_delete(vo.getBoard_sn()) > 0) {
				System.out.println("글삭제 성공ㅎ");
				return "redirect:board_list";
			} else {
				System.out.println("글삭제 실패ㅠ");
				model.addAttribute("boardVO", vo);
				model.addAttribute("jsonVO", gson.toJson(vo));
				model.addAttribute("path", "/board_detail");
				return "zzchaminhwan04board/board_00_main";
			}
		} else {
			return "home";
		}
		model.addAttribute("path", path);
		return "zzchaminhwan04board/board_00_main";
	}
//======================================================================================================================
}
