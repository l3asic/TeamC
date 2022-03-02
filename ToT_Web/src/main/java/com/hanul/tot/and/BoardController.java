package com.hanul.tot.and;

import java.io.IOException;
import java.util.ArrayList;
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

import com.google.gson.Gson;

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

	@RequestMapping(value = "/board_*")
	public String board(BoardVO vo, Locale locale, HttpSession session, Model model, HttpServletRequest req,
			MultipartFile multipartFile) throws IOException {
		String path = req.getServletPath();
		logger.info((chaminhwan.cnt++) + " =>=> " + "Welcome home! The client locale is {}.", locale);
		printPath(path);

		if (path.equals("/board_list")) {// ==================== board_list ====================
			printPath(path);
			// ====================
			BoardVO boardVO = new BoardVO();
			boardVO.setBoard_class("user");
			boardVO.setList_cnt_many(999);
			List<BoardVO> list = boardServiceImpl.board_list(boardVO);

			model.addAttribute("boardVO", list);
		} else if (path.equals("/board_list_stack")) {// ==================== bpard_list_stack ====================
			printPath(path);
			List<BoardVO> list = boardServiceImpl.board_list(vo);
			model.addAttribute("boardVO", list);
			return "zzchaminhwan04board/board_01_list_stack";
		} else if (path.equals("/board_detail")) {// ==================== board_detail ====================
			printPath(path);
			// ====================
			vo = boardServiceImpl.board_detail(vo.getBoard_sn());

			model.addAttribute("boardVO", vo);
			model.addAttribute("crlf", "\r\n");
			model.addAttribute("jsonVO", gson.toJson(vo));
		} else if (path.equals("/board_new")) {// ==================== board_new 글쓰기 화면 ====================
			printPath(path);
			// ====================

		} else if (path.equals("/board_insert")) {// ==================== board_insert 글 등록 ====================
			printPath(path);
			// ====================
			vo.setBoard_class("user");
			vo.setMember_id("ChaMinHwan");
//			MemberVO memberVO = (MemberVO) session.getAttribute("loginInfo");
//			vo.setMember_id(memberVO.getMember_id());

//			 파일 정보가 있다면
			if (!multipartFile.isEmpty()) {
				vo.setPicture_filepath(common.fileupload("board", multipartFile, session));
//				List<BoardVO> list = new ArrayList<BoardVO>();
//				list.add(vo);
				sql.insert("picture.mapper.insert_picture_board", vo);
				return "redirect:board_list";
			}

			boardServiceImpl.board_insert(vo);
			return "redirect:board_list";
		} else if (path.equals("/board_delete")) {// ==================== board_delete ====================
			printPath(path);
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
		} else if (path.equals("/board_go_update")) {// ==================== board_go_update 수정화면====================
			model.addAttribute("boardVO", vo);
			return "zzchaminhwan04board/board_01_update";
		} else if (path.equals("/board_update")) {// ==================== board_update 수정처리====================
			printPath(path);
			if (boardServiceImpl.board_update(vo) > 0) {
				System.out.println("글수정 성공ㅎ");

			} else {
				System.out.println("글수정 실패ㅠ");
			}
			model.addAttribute("boardVO", vo);
			model.addAttribute("jsonVO", gson.toJson(vo));
			model.addAttribute("path", "/board_detail");
			return "zzchaminhwan04board/board_00_main";
		} else {
			return "home";
		}
		model.addAttribute("path", path);
		return "zzchaminhwan04board/board_00_main";
	}

	public void printPath(String path) {
		System.out.println("path : " + path);
	}

	// ========================================================방명록 글에 대한 댓글 저장처리 요청
	@RequestMapping("/board/comment/list")
	public String comment_list(ReplyVO replyVO, Locale locale, HttpSession session, Model model,
			HttpServletRequest req) {
		String path = req.getServletPath();
		printPath(path);
		// 해당 글에 대한 댓글들을 DB에서 조회해 온다.
		List<ReplyVO> replyList = boardServiceImpl.reply_list(replyVO);
		model.addAttribute("replyList", replyList);
		model.addAttribute("crlf", "\r\n");
		model.addAttribute("lf", "\n");

		return "zzchaminhwan04board/comment/comment_list";
	}

	// ====================================================방명록 글에 대한 댓글 저장처리 요청
	@ResponseBody
	@RequestMapping("/board/comment/regist")
	public boolean comment_regist(ReplyVO replyVO, HttpSession session) {
		// 작성자의 경우 member 의 id 값을 담아야 하므로 로그인 정보 확인
		MemberVO member = (MemberVO) session.getAttribute("loginInfo");
		replyVO.setMember_id(member.getMember_id());

		// 화면에서 입력한 댓글 정보를 DB에 저장한 후 저장 여부를 반환
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
