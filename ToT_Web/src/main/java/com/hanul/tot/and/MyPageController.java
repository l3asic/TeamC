package com.hanul.tot.and;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpResponse;
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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

import chaminhwan.board.BoardPage;
import chaminhwan.board.BoardServiceImpl;
import chaminhwan.board.BoardVO;
import chaminhwan.board.ReplyVO;
import common.CommonService;
import common.MatchingVO;
import common.chaminhwan;
import member.MemberVO;

@Controller
public class MyPageController {

	private static final Logger logger = LoggerFactory.getLogger(MyPageController.class);

	Gson gson = new Gson();
	@Autowired
	@Qualifier("cteam")
	SqlSession sql;
	
	@Autowired
	private CommonService common;
	@RequestMapping("/mypage_{member_id}")
	public String myPage(@PathVariable String member_id, Locale locale, HttpSession session, Model model,
			HttpServletRequest req, HttpServletResponse res) throws IOException {
		String path = req.getServletPath();

		int memberCheck = sql.selectOne("member.mapper.memberid_check", member_id);
//		if (memberCheck > 0) {

		MemberVO memberVO = new MemberVO();
		memberVO = sql.selectOne("mypage.mapper.selectvo", member_id);

		model.addAttribute("path", "/mypage_");
		model.addAttribute("memberVO", memberVO);

		if (session.getAttribute("loginInfo") != null) {
			MemberVO my_memberVO = (MemberVO) session.getAttribute("loginInfo");
			if(! member_id.equals(my_memberVO.getMember_id())) {
			MatchingVO matchingVO = new MatchingVO();
			matchingVO.setMy_member_id(my_memberVO.getMember_id());
			matchingVO.setWhose_member_id(member_id);
			String matchingScore = sql.selectOne("mbti.mapper.matching_user", matchingVO);
			model.addAttribute("matchingScore",matchingScore);
			}
		}
		return "zzchaminhwan04board/board_00_main";
	}

	@RequestMapping("/mypage_list_*")
	public String list(BoardVO vo, Locale locale, HttpSession session, Model model, HttpServletRequest req)
			throws IOException {
		String path = req.getServletPath();
		System.out.println(path);
		
		
		if(path.equals("/mypage_list_timeline")) {
			vo.setStack(vo.getStack() * 8);
			List<ReplyVO> list = sql.selectList("mypage.mapper." + path, vo);
			model.addAttribute("replyList", list);
			return "zzchaminhwan00mypage/mypage_00_grid_stack";
		}else {
			vo.setStack(vo.getStack() * 10);
			List<BoardVO> list = sql.selectList("mypage.mapper." + path, vo);
			model.addAttribute("boardVO", list);
			return "zzchaminhwan00mypage/mypage_00_list_stack";
		}

		
	}

	

	@RequestMapping("/my_modify")
	public String mypage_modify(String member_id, Model model, HttpSession session ,HttpServletRequest req) {
		if(chaminhwan.isLoginedCheck(session) == false) {
			return "redirect:home";
		}

		MemberVO vo = sql.selectOne("mypage.mapper.member_info", member_id);

		model.addAttribute("vo", vo);

		return "zzchaminhwan00mypage/my_modify";
	}
	
	@RequestMapping("/my_info_update")
	public String update(Model model, MemberVO memberVO, HttpSession session, MultipartFile multipartFile,
			HttpServletRequest req) {
		chaminhwan.printPath(req);
		

		if(! multipartFile.isEmpty()) {
			System.out.println("파일들어옴");
			
			String filepath = common.fileupload("member_profile", multipartFile, session);
			memberVO.setMember_filepath(filepath);
		}

		sql.update("mypage.mapper.member_pic_update", memberVO);
		sql.update("mypage.mapper.member_info_update",memberVO);

		return "redirect:/mypage_" + memberVO.getMember_id();
	}

//======================================================================================================================
}
