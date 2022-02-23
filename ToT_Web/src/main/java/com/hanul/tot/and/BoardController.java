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

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	CommonService service;
	@Autowired
	private CategoryDAO dao;
	
	Gson gson = new Gson();


	@RequestMapping("/board_*")
	public String board(Locale locale, HttpSession session, Model model)
			throws IOException {
		logger.info((chaminhwan.cnt++) + " =>=> " + "Welcome home! The client locale is {}.", locale);


		return "home";
	}

}
