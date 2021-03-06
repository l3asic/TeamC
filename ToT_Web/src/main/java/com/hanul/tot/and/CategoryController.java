package com.hanul.tot.and;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import category.CategoryDAO;
import category.CategoryPage;
import category.CategoryVO;
import common.CommonService;
import common.MatchingVO;
import member.MemberVO;
import member.TendVO;
import category.PictureVO;
import category.ReplyVO;
import chaminhwan.board.BoardVO;

@Controller
public class CategoryController {
	@Autowired
	@Qualifier("cteam")
	SqlSession sql;

	@Autowired
	CommonService service;
	@Autowired
	private CategoryDAO dao;
	@Autowired
	private CategoryPage page;
	Gson gson = new Gson();

	// 성향분석 값 입력 요청
	@RequestMapping("/tend_join_category")
	public String tend(TendVO vo, HttpSession session) {

//		service.tend_join(vo); //member.mapper.tend_join 안보임.
		sql.update("tend.mapper.category_tend_merge", vo);

		return "redirect:detail.ca?board_sn="+vo.getBoard_sn();
	}
	
	// 성향분석 화면 요청
	@RequestMapping("/tend_category")
	public String tend(HttpSession session, Model model,TendVO vo, int board_sn) {


		vo = sql.selectOne("tend.mapper.selectcategory",board_sn);

		model.addAttribute("board_sn", board_sn);
		model.addAttribute("tendVO", vo);


		return "category/tend_category";
	}
	
	
	@ResponseBody
	@RequestMapping("/category_reply")
	public void reply_insert(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws IOException {

		String tempVo = req.getParameter("category");
		CategoryVO vo = gson.fromJson(tempVo, CategoryVO.class);
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();
		int pictureCount = vo.getPicture_file_count();
		ArrayList<String> serverPathList = new ArrayList<String>();

		if (pictureCount != 0) {
			MultipartRequest mulReq = (MultipartRequest) req;
			for (int i = 0; i < vo.getPicture_file_count(); i++) {
				MultipartFile file = mulReq.getFile("file" + i);
				System.out.println("Null 아님 파일 들어옴");
				String path = service.fileupload("and", file, session);
				String server_path = "http://" + req.getLocalAddr() + ":" + req.getLocalPort() + req.getContextPath()
						+ "/resources/";
				System.out.println(server_path + path);
				serverPathList.add(server_path + path);
			}

		} else {
			System.out.println("파일 안들어옴");
		}

		System.out.println(vo.getBoard_sn());
		System.out.println(vo.getBoard_title());
		System.out.println(vo.getBoard_class());
		System.out.println(vo.getMember_id());

		System.out.println(vo.getBoard_content());

		System.out.println(dao.reply_insert(vo) + "asdasdasd");

		if (pictureCount != 0) {
			ArrayList<PictureVO> pictureVOs = new ArrayList<PictureVO>();
			for (String path : serverPathList) {
				PictureVO pVO = new PictureVO();
				pVO.setPicture_filepath(path);
				pVO.setMember_id(vo.getMember_id());
				pVO.setBoard_sn(vo.getBoard_sn());
				pictureVOs.add(pVO);
			}
			if (pictureVOs.size() != 0)
				dao.reply_picture_insert(pictureVOs);
		}

	}

	@RequestMapping("/tour.ca")
	public String detail_tour(HttpSession session, Model model, @RequestParam(defaultValue = "1") int curPage)
			throws IOException {
		// DB에서 목록을 조회해와 목록화면에 출력
		// 페이지 정보를 담아 페이징된 목록 조회

//		List<CategoryVO> list = dao.catetour_list();
//		MemberVO vo = (MemberVO) session.getAttribute("loginInfo");
//		String member_id = vo.getMember_id();

		page.setCurPage(curPage);

		model.addAttribute("page", dao.catetour_list(page));

		// model.addAttribute("member_id", list.get(0).getMember_id());
//		model.addAttribute("member_id", member_id);
		return "category/tour";

	}

	@RequestMapping("/activity.ca")
	public String detail_activity(HttpSession session, Model model, @RequestParam(defaultValue = "1") int curPage)
			throws IOException {
		/*
		 * System.out.println("detail_activity 확인");
		 * 
		 * List<CategoryVO> list = dao.cateact_list();
		 */
		/*
		 * req.setCharacterEncoding("UTF-8"); res.setCharacterEncoding("UTF-8");
		 * res.setContentType("text/html");
		 */

		page.setCurPage(curPage);

		model.addAttribute("page", dao.cateact_list(page));

		// model.addAttribute("vo", list);
		return "category/activity";

	}

	@RequestMapping("/festival.ca")
	public String detail_festival(HttpSession session, Model model, @RequestParam(defaultValue = "1") int curPage)
			throws IOException {

		page.setCurPage(curPage);

		model.addAttribute("page", dao.catefes_list(page));

		// model.addAttribute("vo", list);
		return "category/festival";

	}

	@ResponseBody
	@RequestMapping("/list_picture")
	public void list_picture(HttpServletRequest req, HttpServletResponse res) throws IOException {
		System.out.println("list_picture 확인");

		int board_sn = Integer.parseInt(req.getParameter("board_sn"));

		List<PictureVO> list = dao.list_picture(board_sn);
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();
		writer.println(gson.toJson(list));

	}

	@ResponseBody
	@RequestMapping("/detail_categoryBoard22")
	public void board_picture_list(HttpServletRequest req, HttpServletResponse res) throws IOException {
		System.out.println("detail_categoryBoard 확인");

		String tempVo = req.getParameter("category");
		CategoryVO vo = gson.fromJson(tempVo, CategoryVO.class);

		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();

	}

	@ResponseBody
	@RequestMapping("/list_reviewpath")
	public void list_reviewpath(HttpServletRequest req, HttpServletResponse res) throws IOException {
		System.out.println("list_reviewpath 확인");

		int board_sn = Integer.parseInt(req.getParameter("board_sn"));

		List<CategoryVO> list = dao.list_reviewpath(board_sn);
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();
		writer.println(gson.toJson(list));

	}

	@ResponseBody
	@RequestMapping("/category_like")
	public void category_like(HttpServletRequest req, HttpServletResponse res) throws IOException {
		System.out.println("list_reviewpath 확인");

		int board_sn = Integer.parseInt(req.getParameter("board_sn"));

		int count = dao.category_like(board_sn);
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();
		writer.println(count);

	}

	@ResponseBody
	@RequestMapping("/set_like")
	public void set_like(HttpServletRequest req, HttpServletResponse res, CategoryVO vo, HttpSession session,
			Model model) throws IOException {
		System.out.println("set_like 확인");

		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();

		JsonObject jb = new JsonObject();

		boolean isLogin = false;

		MemberVO mvo = (MemberVO) session.getAttribute("loginInfo");
		if (mvo != null) {

			isLogin = true;
			vo.setMember_id(mvo.getMember_id());
			vo.setBoard_sn(Integer.parseInt(req.getParameter("board_sn")));
			vo.setFunction_like(Integer.parseInt(req.getParameter("like_fn")));

			int likeCount = 0;
			boolean isCheckYN = false;
			System.out.println(vo.getBoard_sn() + "\t" + vo.getMember_id());

			try {
				System.out.println(vo.getFunction_like());
				int likeCk = dao.categoryLike_sn_member(vo);

				if (likeCk > 0) { // 좋아요 삭제
					dao.like_delete(vo);
					isCheckYN = false;
				} else { // 좋아요 추가
					dao.like_insert(vo);
					isCheckYN = true;

				}

				likeCount = dao.category_like(vo.getBoard_sn());

				int likeCheck = dao.categoryLike_sn_member(vo);

				jb.addProperty("isLike", isCheckYN); // or false
				jb.addProperty("count", likeCount);
				jb.addProperty("likeCheck", likeCheck);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		jb.addProperty("isLogin", isLogin);
		writer.println(jb);

	}

	@RequestMapping("/detail.ca")
	public String detail_categoryBoard(Model model, CategoryVO vo, HttpServletRequest req, HttpServletResponse res,
			HttpSession session) throws IOException {
//		  CategoryVO vo= dao.detail_categoryBoard(board_sn);
		sql.update("board.mapper.read", vo.getBoard_sn());

		int board_sn = vo.getBoard_sn();
		int likeCheck = 0;

		MemberVO mvo = (MemberVO) session.getAttribute("loginInfo");

		if (null != mvo) {
			vo.setMember_id(mvo.getMember_id());
			likeCheck = dao.categoryLike_sn_member(vo);

			// =================== 차민환 : 여행지 매칭점수
			MatchingVO matchingVO = new MatchingVO();
			matchingVO.setMy_member_id(mvo.getMember_id());
			matchingVO.setWhere_board_sn(vo.getBoard_sn());
			String matchingScore = sql.selectOne("mbti.mapper.matching_where", matchingVO);
			model.addAttribute("matchingScore", matchingScore);
			// ======================================
		}

		List<PictureVO> list = dao.list_picture(board_sn);

		int count = dao.category_like(board_sn);

		List<CategoryVO> reviewList = dao.list_reviewpath(board_sn);

		model.addAttribute("likeCheck", likeCheck);
		model.addAttribute("vo", dao.detail_categoryBoard(vo));
		model.addAttribute("picture", list);
		model.addAttribute("likeCount", count);
		model.addAttribute("review", reviewList);
//		  model.addAttribute("repic", replyPic);
		model.addAttribute("crlf", "\r\n");
		model.addAttribute("lf", "\n");
		model.addAttribute("likeclick", vo);
		return "category/detail";
	}

	// 새로 글쓰기창
	@RequestMapping("/newreply.ca")
	public String new_reply(Model model, HttpServletRequest req, HttpSession session) {

		int board_sn = Integer.parseInt(req.getParameter("board_sn"));
		MemberVO mvo = (MemberVO) session.getAttribute("loginInfo");
		String member_id = mvo.getMember_id();

		model.addAttribute("board_sn", board_sn);
		model.addAttribute("member_id", member_id);
		return "category/new";
	}

	@RequestMapping(value = "/replyinsert.ca", method = RequestMethod.POST)
	public String reply_insert(MultipartHttpServletRequest req, ReplyVO vo, MultipartFile multipartFile,
			HttpSession session, Model model, List<MultipartFile> multipartFileList) {

		int board_sn = Integer.parseInt(req.getParameter("board_sn"));

		MemberVO mvo = (MemberVO) session.getAttribute("loginInfo");

		// ===================== 차민환 - 댓글사진 =============================
		vo.setMember_id(mvo.getMember_id());
		vo.setBoard_sn(board_sn);
		if (!multipartFile.isEmpty()) {
			List<MultipartFile> mpfList = req.getFiles("multipartFile");
			List<PictureVO> picList = new ArrayList<PictureVO>();

			for (int i = 0; i < mpfList.size(); i++) {
				PictureVO picVO = new PictureVO();
				String filepath = service.fileupload("category", mpfList.get(i), session);
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
		} // ================================================================

		model.addAttribute("board_sn", vo.getBoard_sn());
		model.addAttribute("reply_sn", vo.getReply_sn());
		sql.insert("picture.mapper.insert_picture_review", vo);

		// dao.insert_reply(vo);

		return "redirect:detail.ca?board_sn={board_sn}";
	}

	@RequestMapping("/delete.ca")
	public String delete(ReplyVO vo, HttpServletRequest req, HttpSession session, Model model) {
		// 첨부 파일이 있는 글에 대해서는 해당 파일을 서버의 물리적 영역에서 삭제

		int board_sn = vo.getBoard_sn();

		int reply_sn = Integer.parseInt(req.getParameter("reply_sn"));
		MemberVO mvo = (MemberVO) session.getAttribute("loginInfo");
		vo.setMember_id(mvo.getMember_id());
		vo.setReply_sn(reply_sn);

		int reply_del = dao.reply_delete(vo);

		// 해당 방명록 글을 DB에서 삭제한 후 목록화면으로 연결
		// return "redirect:list.bo";
		model.addAttribute("replyDel", reply_del);
		model.addAttribute("reply_sn", vo.getReply_sn());
		model.addAttribute("member_id", vo.getMember_id());
		model.addAttribute("board_sn", board_sn);
//		model.addAttribute("page", page);
		return "redirect:detail.ca?board_sn={board_sn}";
	}

	@RequestMapping(value = "/replydelete")
	public String reply_delete(HttpServletRequest req, ReplyVO vo, MultipartFile file, HttpSession session,
			Model model) {
		int board_sn = vo.getBoard_sn();

		int reply_sn = Integer.parseInt(req.getParameter("reply_sn"));
		MemberVO mvo = (MemberVO) session.getAttribute("loginInfo");
		vo.setReply_sn(reply_sn);

		int reply_del = dao.reply_delete(vo);

		// 해당 방명록 글을 DB에서 삭제한 후 목록화면으로 연결
		// return "redirect:list.bo";
		model.addAttribute("replyDel", reply_del);
		model.addAttribute("reply_sn", vo.getReply_sn());
		model.addAttribute("member_id", vo.getMember_id());
		model.addAttribute("board_sn", board_sn);
//		model.addAttribute("page", page);
		return "redirect:detail.ca?board_sn={board_sn}";
	}

	@RequestMapping("/category_write_view")
	public String viewWrite(BoardVO boardVO, Model model, HttpSession session, HttpServletRequest req)
			throws IOException {
		String path = req.getServletPath();
		System.out.println(path);

		model.addAttribute("boardVO", boardVO);
		return "category/write";
	}

	@RequestMapping("/category_write_insert")
	public String viewWrite(BoardVO boardVO, Model model, HttpSession session, MultipartHttpServletRequest req,
			MultipartFile multipartFile, List<MultipartFile> multipartFileList) throws IOException {
		String path = req.getServletPath();
		System.out.println(path);

		MemberVO memberVO = (MemberVO) session.getAttribute("loginInfo");
		if (boardVO.getMember_id() == null) {
			boardVO.setMember_id("ChaMinHwan");
		}
//		 파일 정보가 있다면
		if (!multipartFile.isEmpty()) {
			List<MultipartFile> mpfList = req.getFiles("multipartFile");
			List<picture.PictureVO> picList = new ArrayList<picture.PictureVO>(); // ================= BoardVO 안에있는
																					// 엘리먼트가 picture.PictureVO임

			for (int i = 0; i < mpfList.size(); i++) {
				picture.PictureVO picVO = new picture.PictureVO();
				String filepath = service.fileupload("board", mpfList.get(i), session);
				picVO.setPicture_filepath(filepath);
				try {

					picList.add(picVO);
					System.out.println(picList.get(i).getPicture_filepath());
				} catch (Exception e) {
					e.printStackTrace();
				}
//		vo.setPicture_filepath(common.fileupload("board", picList.get(i), session));

//		vo.setPicList(picList);
			}
			boardVO.setPicList(picList);
			sql.insert("picture.mapper.insert_picture_board", boardVO);
			return "redirect:" + boardVO.getBoard_class() + ".ca";
		} else {

		}

		sql.insert("board.mapper.insert", boardVO);

		return "redirect:" + boardVO.getBoard_class() + ".ca";
	}

//	@RequestMapping("")
//	public String insertWrite() {
//
//	}

}
