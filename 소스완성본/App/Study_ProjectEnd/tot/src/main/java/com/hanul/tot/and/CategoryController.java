package com.hanul.tot.and;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;

import com.google.gson.Gson;

import category.CategoryDAO;
import category.CategoryVO;
import category.ReplyVO;
import common.CommonService;
import picture.PictureVO;

@Controller
public class CategoryController {
	
	@Autowired CommonService service;
	@Autowired private CategoryDAO dao;
	Gson gson = new Gson();


	// 이 밑으로부터 코드작성
	@ResponseBody
	@RequestMapping("/category_list")
	public void category_list(HttpServletRequest req, HttpServletResponse res) throws IOException {
		System.out.println("grid list 확인");
		
		List<CategoryVO> list = dao.catetour_list();
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();
		writer.println( gson.toJson(list));
		
	}
	
	@ResponseBody
	@RequestMapping("/category_reply")
	public void reply_insert(HttpServletRequest req, HttpServletResponse res,HttpSession session) throws IOException {
		
		String tempVo = req.getParameter("reply");
		ReplyVO vo = gson.fromJson(tempVo, ReplyVO.class);
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();
		int pictureCount = vo.getPicture_file_count();
		ArrayList<String> serverPathList = new ArrayList<String>();
		
		if(pictureCount != 0) {
			MultipartRequest mulReq = (MultipartRequest) req;
			for (int i = 0; i < vo.getPicture_file_count(); i++) {
				MultipartFile file = mulReq.getFile("file"+i);
				System.out.println("Null 아님 파일 들어옴");
				String path = service.fileupload("and", file, session);
				/*
				 * String server_path = "http://" + req.getLocalAddr() + ":" +
				 * req.getLocalPort() + req.getContextPath()+"/resources/";
				 * System.out.println(server_path + path);
				 */
				serverPathList.add(path);
			}
			
			/*
			 * vo.setFilepath(server_path + path); result =
			 * sql.insert("member.mapper.insert", vo);
			 */
			
		}else {
			System.out.println("파일 안들어옴");
		}
		
		System.out.println(vo.getBoard_sn());
		System.out.println(vo.getMember_id());
		System.out.println(vo.getReply_content());

		System.out.println(dao.reply_insert(vo) + "asdasdasd");
		
		if(pictureCount != 0) {
			ArrayList<PictureVO> pictureVOs = new ArrayList<PictureVO>();
			for(String path : serverPathList) {
				PictureVO pVO = new PictureVO();
				pVO.setPicture_filepath(path);
				pVO.setMember_id(vo.getMember_id());
				pVO.setReply_sn(vo.getReply_sn());
				pictureVOs.add(pVO);
			}
			if(pictureVOs.size() != 0)
				dao.reply_picture_insert(pictureVOs);
		}
		
	}
	
	@ResponseBody
	@RequestMapping("/categoryList_tour")
	public void detail_tour(HttpServletRequest req, HttpServletResponse res) throws IOException {
		System.out.println("detail_tour 확인");
		
		List<CategoryVO> list = dao.catetour_list();
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();
		writer.println( gson.toJson(list));
		
	}
	
	@ResponseBody
	@RequestMapping("/categoryList_activity")
	public void detail_activity(HttpServletRequest req, HttpServletResponse res) throws IOException {
		System.out.println("detail_activity 확인");
		
		List<CategoryVO> list = dao.cateact_list();
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();
		writer.println( gson.toJson(list));
		
	}
	
	@ResponseBody
	@RequestMapping("/categoryList_festival")
	public void detail_festival(HttpServletRequest req, HttpServletResponse res) throws IOException {
		System.out.println("detail_festival 확인");
		
		List<CategoryVO> list = dao.catefes_list();
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();
		writer.println( gson.toJson(list));
		
	}
	
	@ResponseBody
	@RequestMapping("/category_detial")
	public void detail_categoryBoard(HttpServletRequest req, HttpServletResponse res) throws IOException {
		System.out.println("detail_categoryBoard 확인");
		
		List<CategoryVO> list = dao.detail_categoryBoard();
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();
		writer.println( gson.toJson(list));
		
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
		writer.println( gson.toJson(list));
		
	}
	
	@ResponseBody
	@RequestMapping("/list_picture_re")
	public void list_picture_re(HttpServletRequest req, HttpServletResponse res) throws IOException {
		System.out.println("list_picture_re 확인");
		
		int reply_sn = Integer.parseInt(req.getParameter("reply_sn"));
		
		List<PictureVO> list = dao.list_picture_re(reply_sn);
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();
		writer.println( gson.toJson(list));
		
	}
	
	@ResponseBody
	@RequestMapping("/detail_categoryBoard")
	public void board_picture_list(HttpServletRequest req, HttpServletResponse res) throws IOException {
		System.out.println("detail_categoryBoard 확인");
		
		String tempVo = req.getParameter("category");
		CategoryVO vo = gson.fromJson(tempVo, CategoryVO.class);
		
		CategoryVO resultVO = dao.detail_categoryBoard(vo);
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();
		writer.println( gson.toJson(resultVO));
		
	}
	
	
	@ResponseBody
	@RequestMapping("/list_reviewpath")
	public void list_reviewpath(HttpServletRequest req, HttpServletResponse res) throws IOException {
		System.out.println("list_reviewpath 확인");
		
		int board_sn = Integer.parseInt(req.getParameter("board_sn"));
		
		List<ReplyVO> list = dao.list_reviewpath(board_sn);
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();
		writer.println( gson.toJson(list));
		
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
	public void set_like(HttpServletRequest req, HttpServletResponse res) throws IOException {
		System.out.println("set_like 확인");
		
		String tempVo = req.getParameter("category");
		CategoryVO vo = gson.fromJson(tempVo, CategoryVO.class);

		if(vo.getFunction_like() > 0) { //좋아요 삭제
			dao.like_delete(vo);
		}else {	//좋아요 추가
			dao.like_insert(vo);
		}
		
	}
	
	@ResponseBody
	@RequestMapping("/detailDelete")
	public void detailDelete(HttpServletRequest req, HttpServletResponse res) throws IOException {
		System.out.println("detailDelete 확인");
		
		int reply_sn = Integer.parseInt(req.getParameter("reply_sn"));
		
		dao.deliteReply(reply_sn);
		
		
		
	}
	
	
}
