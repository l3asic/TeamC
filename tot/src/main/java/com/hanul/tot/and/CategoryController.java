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
import common.CommonService;
import category.PictureVO;

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
			System.out.println("파일 안들어옴..");
		}
		
		System.out.println(vo.getBoard_sn());
		System.out.println(vo.getBoard_title());
		System.out.println(vo.getBoard_class());
		System.out.println(vo.getMember_id());
		
		System.out.println(vo.getBoard_content());
		
		dao.reply_insert(vo);
		
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
	

}
