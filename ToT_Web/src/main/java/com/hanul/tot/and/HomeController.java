package com.hanul.tot.and;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import chaminhwan.board.BoardVO;
import common.chaminhwan;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	@Qualifier("cteam")
	SqlSession sql;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(HttpSession session, Locale locale, Model model) {
		logger.info((chaminhwan.cnt++)+ " =>=> " +"Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		List<BoardVO> vo_readcnt = sql.selectList("home.mapper.orderby_readcnt");
		BoardVO vo_likes =sql.selectOne("home.mapper.orderby_likes");
	BoardVO vo_replycnt =sql.selectOne("home.mapper.orderby_replycnt");
		model.addAttribute("vo_readcnt",vo_readcnt);
		model.addAttribute("vo_likes",vo_likes);
		model.addAttribute("vo_replycnt",vo_replycnt);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "./././home";
	}
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home2(HttpSession session, Locale locale, Model model) {
		logger.info((chaminhwan.cnt++)+ " =>=> " +"Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		
		List<BoardVO> vo_readcnt = sql.selectList("home.mapper.orderby_readcnt");
		BoardVO vo_likes =sql.selectOne("home.mapper.orderby_likes");
	BoardVO vo_replycnt =sql.selectOne("home.mapper.orderby_replycnt");
		model.addAttribute("vo_readcnt",vo_readcnt);
		model.addAttribute("vo_likes",vo_likes);
		model.addAttribute("vo_replycnt",vo_replycnt);
		
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/empty")
	public String emty() {
		return "empty";
	}
	
}
