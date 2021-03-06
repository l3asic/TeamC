package com.hanul.tot.and;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.Gson;

import category.CategoryDAO;
import category.CategoryVO;
import chaminhwan.board.BoardPage;
import chaminhwan.board.BoardServiceImpl;
import chaminhwan.board.BoardVO;
import chaminhwan.board.ReplyVO;
import common.CommonService;
import common.chaminhwan;
import member.MemberVO;
import picture.PictureVO;

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

	@Autowired
	@Qualifier("cteam")
	SqlSession sql;

	Gson gson = new Gson();

	/*
	 * @RequestMapping("/boardlist_*") public String boardList(@PathVariable BoardVO
	 * vo, Locale locale, HttpSession session, Model model, HttpServletRequest req,
	 * MultipartFile multipartFile) throws IOException {
	 * 
	 * return "empty"; }
	 */

//	==================================================== MultipartHttpServletRequest =======
	@RequestMapping("/multi_board_*")
	public String multi_board(BoardVO vo, Locale locale, HttpSession session, Model model,
			MultipartHttpServletRequest req, MultipartFile multipartFile, List<MultipartFile> multipartFileList)
			throws IOException {
		String path = req.getServletPath();
//			 ?????? ????????? ?????????
		if (!multipartFile.isEmpty()) {
			List<MultipartFile> mpfList = req.getFiles("multipartFile");
			List<PictureVO> picList = new ArrayList<PictureVO>();

			for (int i = 0; i < mpfList.size(); i++) {
				PictureVO picVO = new PictureVO();
				String filepath = common.fileupload("board", mpfList.get(i), session);
				picVO.setPicture_filepath(filepath);
				try {

					picList.add(picVO);
					System.out.println(picList.get(i).getPicture_filepath());
				} catch (Exception e) {
					e.printStackTrace();
				}
//			vo.setPicture_filepath(common.fileupload("board", picList.get(i), session));

//			vo.setPicList(picList);
			}
			vo.setPicList(picList);
			sql.insert("picture.mapper.insert_picture_board", vo);
			return "redirect:board_list?board_class=" + vo.getBoard_class();
		}

		sql.insert("board.mapper.insert", vo);
		return "redirect:board_list?board_class=" + vo.getBoard_class();
	}
//	=========================================================================================

	@RequestMapping(value = "/board_*")
	public String board(BoardVO vo, Locale locale, HttpSession session, Model model, HttpServletRequest req,
			MultipartFile multipartFile, List<MultipartFile> multipartFileList) throws IOException {
		String path = req.getServletPath();
		logger.info((chaminhwan.cnt++) + " =>=> " + "Welcome home! The client locale is {}.", locale);
		printPath(path);

		if (path.equals("/board_list")) {// ==================== board_list ====================
			printPath(path);
			// ====================
//			vo.setBoard_class("user");
//			vo.setList_cnt_many(999);
//			List<BoardVO> list = boardServiceImpl.board_list(vo);

			model.addAttribute("boardVO", vo);
		} else if (path.equals("/board_list_stack")) {// ==================== bpard_list_stack ====================
			printPath(path);
			List<BoardVO> list = boardServiceImpl.board_list(vo);
			model.addAttribute("boardVO", list);
			return "zzchaminhwan04board/board_01_list_stack";
		} else if (path.equals("/board_detail")) {// ==================== board_detail ====================
			printPath(path);
			// ====================
			String board_class = vo.getBoard_class();

			if (board_class.equals("user") || board_class.equals("user2")) {
				vo = boardServiceImpl.board_detail(vo.getBoard_sn());

				List<PictureVO> picList = new ArrayList<PictureVO>();
				picList = sql.selectList("picture.mapper.detail_pic_list", vo);
				vo.setPicList(picList);

				int likeCheck = 0;

				MemberVO mvo = (MemberVO) session.getAttribute("loginInfo");
				if (null != mvo) {
					vo.setMember_id(mvo.getMember_id());
					likeCheck = sql.selectOne("category.mapper.categoryLike_sn_member", vo);
				}
				int count = sql.selectOne("category.mapper.category_like", vo.getBoard_sn());

				model.addAttribute("likeCheck", likeCheck);
				model.addAttribute("likeCount", count);
				model.addAttribute("boardVO", vo);
				model.addAttribute("crlf", "\r\n");
				model.addAttribute("jsonVO", gson.toJson(vo));
			} else if (board_class.equals("tour") || board_class.equals("activity") || board_class.equals("festival")) {
				// ======================================= ?????????????????? ?????????????????? ======================

				int board_sn = vo.getBoard_sn();
				int likeCheck = 0;

				MemberVO mvo = (MemberVO) session.getAttribute("loginInfo");

				// ======== gson ???????????????==============
				String temp0 = gson.toJson(vo);
				CategoryVO categoryVO = gson.fromJson(temp0, CategoryVO.class);
				// =================================
				if (null != mvo) {
					categoryVO.setMember_id(mvo.getMember_id());
					likeCheck = sql.selectOne("category.mapper.categoryLike_sn_member", categoryVO);
				}

				List<category.PictureVO> list = sql.selectList("category.mapper.list_picture", board_sn);

				int count = sql.selectOne("category.mapper.category_like", board_sn);

				List<category.CategoryVO> reviewList = sql.selectList("category.mapper.list_reviewpath", board_sn);

				model.addAttribute("likeCheck", likeCheck);
				model.addAttribute("vo", sql.selectOne("category.mapper.detail_categoryBoards", vo));
				model.addAttribute("picture", list);
				model.addAttribute("likeCount", count);
				model.addAttribute("review", reviewList);
//				  model.addAttribute("repic", replyPic);
				model.addAttribute("crlf", "\r\n");
				model.addAttribute("likeclick", categoryVO);
				return "category/detail";
				// ===================================================================================
			}
		} else if (path.equals("/board_new")) {// ==================== board_new ????????? ?????? ====================
			printPath(path);
			// ====================

		} else if (path.equals("/board_insert")) {// ==================== board_insert ??? ?????? ====================
			printPath(path);
			// ====================
			MemberVO memberVO = (MemberVO) session.getAttribute("loginInfo");
			vo.setMember_id(memberVO.getMember_id());

//			 ?????? ????????? ?????????
			if (!multipartFile.isEmpty()) {
				String filepath = common.fileupload("board", multipartFile, session);
				vo.setPicture_filepath(filepath);
				List<PictureVO> picList = new ArrayList<PictureVO>();
				vo.setPicList(picList);

				sql.insert("picture.mapper.insert_picture_board", vo);
				return "redirect:board_list?board_class=" + vo.getBoard_class();
			} else {
			}

			boardServiceImpl.board_insert(vo);
//			return "redirect:board_list";
			return "redirect:board_list?board_class=" + vo.getBoard_class();
		} else if (path.equals("/board_delete")) {// ==================== board_delete ====================
			printPath(path);
			// ====================
			if (boardServiceImpl.board_delete(vo.getBoard_sn()) > 0) {
				System.out.println("????????? ?????????");
				if ("user".equals(vo.getBoard_class())) {
					return "redirect:board_list?board_class=" + vo.getBoard_class();
				} else if ("tour".equals(vo.getBoard_class()) || "activity".equals(vo.getBoard_class())
						|| "festival".equals(vo.getBoard_class())) {
					return "redirect:" + vo.getBoard_class() + ".ca";
				}
				return "redirect:home";
			} else {
				System.out.println("????????? ?????????");
				model.addAttribute("boardVO", vo);
				model.addAttribute("jsonVO", gson.toJson(vo));
				model.addAttribute("path", "/board_detail");
				return "redirect:home";
			}
		} else if (path.equals("/board_go_update")) {// ==================== board_go_update ????????????====================
			model.addAttribute("boardVO", vo);
			return "zzchaminhwan04board/board_01_update";
		} else if (path.equals("/board_update")) {// ==================== board_update ????????????====================
			printPath(path);
			if (boardServiceImpl.board_update(vo) > 0) {
				System.out.println("????????? ?????????");

			} else {
				System.out.println("????????? ?????????");
			}
			vo.setBoard_class("user");
			model.addAttribute("boardVO", vo);
			model.addAttribute("jsonVO", gson.toJson(vo));
			model.addAttribute("path", "/board_list");
			return "zzchaminhwan04board/board_00_main";
		} else {
			return "redirect:home";
		}
		model.addAttribute("path", path);
		return "zzchaminhwan04board/board_00_main";
	}

	public void printPath(String path) {
		System.out.println("path : " + path);
	}

	// ========================================================????????? ?????? ?????? ?????? ?????? ??????
	@RequestMapping("/board/comment/list")
	public String comment_list(ReplyVO replyVO, Locale locale, HttpSession session, Model model,
			HttpServletRequest req) {
		String path = req.getServletPath();
		printPath(path);
		// ?????? ?????? ?????? ???????????? DB?????? ????????? ??????.
		List<ReplyVO> replyList = boardServiceImpl.reply_list(replyVO);
		model.addAttribute("replyList", replyList);
		model.addAttribute("crlf", "\r\n");
		model.addAttribute("lf", "\n");

		return "zzchaminhwan04board/comment/comment_list";
	}

	// ====================================================????????? ?????? ?????? ?????? ???????????? ??????
	@ResponseBody
	@RequestMapping("/board/comment/regist")
	public boolean comment_regist(ReplyVO replyVO, HttpSession session) {
		// ???????????? ?????? member ??? id ?????? ????????? ????????? ????????? ?????? ??????
		MemberVO member = (MemberVO) session.getAttribute("loginInfo");
		replyVO.setMember_id(member.getMember_id());

		// ???????????? ????????? ?????? ????????? DB??? ????????? ??? ?????? ????????? ??????
		return boardServiceImpl.board_comment_insert(replyVO) == 1 ? true : false;
	}

	@ResponseBody
	@RequestMapping("/board/comment/delete/")
	public boolean reply_delete(int reply_sn, HttpSession session) {

		return boardServiceImpl.reply_delete(reply_sn) == 1 ? true : false;
	}

	@ResponseBody
	@RequestMapping("/board/comment/update")
	public boolean reply_update(ReplyVO replyVO, HttpSession session) {

		return boardServiceImpl.reply_update(replyVO) == 1 ? true : false;
	}
//======================================================================================================================
}
