package com.hanul.tot.and;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
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
	public String board(Locale locale, HttpSession session, Model model, HttpServletRequest req) throws IOException {
		String path = req.getServletPath();
		logger.info((chaminhwan.cnt++) + " =>=> " + "Welcome home! The client locale is {}.", locale);
		System.out.println("path : " + path);

		if (path.equals("/board_list")) {
			BoardVO boardVO = new BoardVO();
			boardVO.setBoard_class("notice");
			boardVO.setList_cnt_many(999);
			List<BoardVO> list = boardServiceImpl.board_list(boardVO);
			model.addAttribute("boardVO", list);
			model.addAttribute("path", path);
			return "zzchaminhwan04board/board_00_main";
		} else if (path.equals("board_detail")) {
			BoardVO boardVO = new BoardVO();

			model.addAttribute("path", path);
			return "zzchaminhwan04board/board_00_main";
		}

		else {
			return "home";
		}
	}
//======================================================================================================================
}
