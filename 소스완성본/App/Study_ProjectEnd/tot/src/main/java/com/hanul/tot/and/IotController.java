package com.hanul.tot.and;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Member;
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
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.iot.IotDAO;
import android.iot.IotVO;
import android.kwk.MemberVO;
import android.partydao.PartyDAO;
import android.partyvo.PartyListVO;
import android.partyvo.PartyMemberListVO;
import android.partyvo.PartyPlanListVO;
import android.partyvo.PlanInfoVO;
import common.CommonService;

@Controller
public class IotController {
	Gson gson = new Gson();

	@Autowired
	CommonService service;
	@Autowired
	IotDAO iDAO;

	@Autowired
	@Qualifier("cteam")
	private SqlSession sql;

	@ResponseBody
	@RequestMapping("/android/iot/saveIot")
	public void saveIot(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws IOException {
		System.out.println("saveIot 메소드 접근");
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();

		IotVO vo = new IotVO();
		String from_and_dto = req.getParameter("dto");		

		vo = (IotVO) gson.fromJson(from_and_dto, IotVO.class);
		List<IotVO> list = new ArrayList<IotVO>();

		try {
			list = iDAO.selectSaveIot(vo);
			
			// 기존에 위치 정보가 있다면 업데이트
			if(list.get(0) != null) {				
				iDAO.updateSaveIot(vo);	
			
			// 정보가 없다면 삽입
			}else {				
				iDAO.insertSaveIot(vo);				
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

	}// saveIot
	
	
//	@ResponseBody
//	@RequestMapping("/android/iot/checkIoT")
//	public void checkIoT(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws IOException {
//		System.out.println("checkIoT() 메소드 접근");
//		req.setCharacterEncoding("UTF-8");
//		res.setCharacterEncoding("UTF-8");
//		res.setContentType("text/html");
//		PrintWriter writer = res.getWriter();
//		
//		
//		int on_off = -1;
//
//		IotVO vo = new IotVO();
//		String member_id = req.getParameter("member_id");			
//
//		
//		List<IotVO> list = new ArrayList<IotVO>();
//		vo.setMember_id(member_id);
//
//		try {
//			list = iDAO.selectSaveIot(vo);
//			
//			// 기존에 데이터가 있다면 온오프값 리턴
//			if(list != null) {
//				vo = list.get(0);							
//				on_off = vo.getIot_onoff();
//			
//			// 정보가 없다면 기본 값(꺼져있음) 삽입
//			}else {
//				on_off = 0;
//				vo.setIot_onoff(on_off);
//				iDAO.insertSaveIot(vo);				
//			}
//			
//			
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		writer.print(on_off);
//
//	}// checkIoT()
	
	
	
	
	@ResponseBody
	@RequestMapping("/android/iot/checkIoT")
	public void checkIoT(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws IOException {
		System.out.println("checkIoT() 메소드 접근");
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();
		
		
		int on_off = -1;

		IotVO vo = new IotVO();
		String member_id = req.getParameter("member_id");			

		
		List<IotVO> list = new ArrayList<IotVO>();
		vo.setMember_id(member_id);
		System.out.println("기존 IoT데이터 없다면 에러뜸 (정상임)");

		try {
			list = iDAO.selectSaveIot(vo);
			
			on_off = list.get(0).getIot_onoff();
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		writer.print(on_off);

	}// checkIoT()
	
	
	
	// 값없으면 기본값 입력
	@ResponseBody
	@RequestMapping("/android/iot/insertIot")
	public void insertIot(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws IOException {
		System.out.println("insertIot() 메소드 접근");
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();
		

		IotVO vo = new IotVO();
		String member_id = req.getParameter("member_id");			

		
		
		vo.setMember_id(member_id);
		
		iDAO.insertSaveIot(vo);
		
		
		
		
		

	}// insertIot()
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@ResponseBody
	@RequestMapping("/android/iot/iotOnOffSet")
	public void iotOnOffSet(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws IOException {
		System.out.println("iotOnOffSet() 메소드 접근");
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();
		
		
		int on_off = -1;

		IotVO vo = new IotVO();
		String member_id = req.getParameter("member_id");
		on_off = Integer.parseInt(req.getParameter("on_off"));	

		
		

		try {
			
			
			// 넘어온 값 온오프에 세팅		
				
			vo.setIot_onoff(on_off);
			vo.setMember_id(member_id);
			iDAO.updateSaveIot(vo);
			on_off = vo.getIot_onoff();
			
			
			
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 세팅된 값 리턴
		writer.print(on_off);

	}// iotOnOffSet()
	
	
	
	
	
	
	
	
	
	

	
}// IotController()