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
public class WhosePageController {

	private static final Logger logger = LoggerFactory.getLogger(WhosePageController.class);
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

@RequestMapping("/whosepage")
	public String whosePage(Locale locale, HttpSession session, Model model, HttpServletRequest req)
			throws IOException {
	
				
				return "home";
}
//======================================================================================================================
}
