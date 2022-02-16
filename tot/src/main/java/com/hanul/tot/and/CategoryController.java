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
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;

import com.google.gson.Gson;

import category.CategoryDAO;
import category.CategoryVO;
import common.CommonService;
import category.PictureVO;

@Controller
public class CategoryController {
	
	@Autowired CommonService service;
	@Autowired private CategoryDAO dao;
	Gson gson = new Gson();


	// 이 밑으로부터 코드작성
	@ResponseBody		
	@RequestMapping("/category_list")		// ★★웹에서 재활용가능					
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
	@RequestMapping("/category_reply")		// ★★ NullPointerException : Cannot invoke "category.CategoryVO.getPicture_file_count()" because "vo" is null
											// 1. 일치하는 키값이 없는 경우
											// 2. @Component 없는 경우(클래스이름위에 붙여주기)
	public void reply_insert(HttpServletRequest req, HttpServletResponse res,HttpSession session) throws IOException {
		
		String tempVo = req.getParameter("category");
		CategoryVO vo = gson.fromJson(tempVo, CategoryVO.class);
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
				String server_path = "http://" + req.getLocalAddr()
				+ ":" + req.getLocalPort() + req.getContextPath()+"/resources/";
				System.out.println(server_path + path);
				serverPathList.add(server_path + path);
			}
			
			/*
			 * vo.setFilepath(server_path + path); result =
			 * sql.insert("member.mapper.insert", vo);
			 */
			
		}else {
			System.out.println("파일 안들어옴");
		}
		
		System.out.println(vo.getBoard_sn());
		System.out.println(vo.getBoard_title());
		System.out.println(vo.getBoard_class());
		System.out.println(vo.getMember_id());
		
		System.out.println(vo.getBoard_content());
		
		System.out.println(dao.reply_insert(vo) + "asdasdasd");
		
		if(pictureCount != 0) {
			ArrayList<PictureVO> pictureVOs = new ArrayList<PictureVO>();
			for(String path : serverPathList) {
				PictureVO pVO = new PictureVO();
				pVO.setPicture_filepath(path);
				pVO.setMember_id(vo.getMember_id());
				pVO.setBoard_sn(vo.getBoard_sn());
				pictureVOs.add(pVO);
			}
			if(pictureVOs.size() != 0)
				dao.reply_picture_insert(pictureVOs);
		}
		
	}
	
	@ResponseBody
	@RequestMapping("/categoryList_tour")		// ★★웹에서 재활용가능
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
	@RequestMapping("/categoryList_activity")		// ★★웹에서 재활용가능
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
	@RequestMapping("/categoryList_festival")		// ★★웹에서 재활용가능
	public void detail_festival(HttpServletRequest req, HttpServletResponse res) throws IOException {
		System.out.println("detail_festival 확인");
		
		List<CategoryVO> list = dao.catefes_list();
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();
		writer.println( gson.toJson(list));
		
	}
	
	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping("/category_detial") public void
	 * detail_categoryBoard(HttpServletRequest req, HttpServletResponse res) throws
	 * IOException { System.out.println("detail_categoryBoard 확인");
	 * 
	 * List<CategoryVO> list = dao.detail_categoryBoard();
	 * req.setCharacterEncoding("UTF-8"); res.setCharacterEncoding("UTF-8");
	 * res.setContentType("text/html"); PrintWriter writer = res.getWriter();
	 * writer.println( gson.toJson(list));
	 * 
	 * }
	 */
	
	@ResponseBody
	@RequestMapping("/list_picture")		// ★★org.springframework.web.util.NestedServletException: 
											//Request processing failed; nested exception is java.lang.NumberFormatException: null
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
	@RequestMapping("/detail_categoryBoard")		// ★★org.springframework.web.util.NestedServletException: 
													// Request processing failed; nested exception is org.mybatis.spring.MyBatisSystemException: 
													// nested exception is org.apache.ibatis.type.TypeException: 
													// Could not set parameters for mapping: ParameterMapping{property='member_id', mode=IN, javaType=class java.lang.Object, jdbcType=null, numericScale=null, resultMapId='null', jdbcTypeName='null', expression='null'}. Cause: org.apache.ibatis.type.TypeException: Error setting null for parameter #1 with JdbcType OTHER . Try setting a different JdbcType for this parameter or a different jdbcTypeForNull configuration property. Cause: java.sql.SQLException: 
													// 부적합한 열 유형: 1111
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
		
		List<CategoryVO> list = dao.list_reviewpath(board_sn);
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
	
	
}
