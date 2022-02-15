package com.hanul.tot.partycontroller;

import java.io.IOException;
import java.io.PrintWriter;
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

import com.google.gson.Gson;

import android.mainburger.MainBurgerNoticeVO;
import android.partydao.PartyDAO;
import android.partyvo.PartyListVO;
import android.partyvo.PartyPlanListVO;
import android.partyvo.ZZMemberVO;

@Controller
public class PartyController {
	Gson gson = new Gson();
	@Autowired
	PartyDAO pDAO;

	@Autowired
	@Qualifier("cteam")
	private SqlSession sql;

	@ResponseBody
	@RequestMapping("/android/party/insertParty")
	public void insertParty(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws IOException {
		System.out.println("insertParty 메소드 접근");
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();

		PartyListVO vo = new PartyListVO();
		String from_and_dto = req.getParameter("dto");
		vo = (PartyListVO) gson.fromJson(from_and_dto, PartyListVO.class);

		/*
		 * vo.setBoard_class(req.getParameter("board_class")+""); list =
		 * sql.selectList("mainburgernotice.mapper.noticelist",vo);
		 */

		try {

			pDAO.insertParty(vo);

			// 이걸 안드로이드에서 가져감 // vo = sql.selectOne("mainburger.mapper.selectThisVs");			
			

			writer.print(gson.toJson(vo));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}//insertParty

	@ResponseBody
	@RequestMapping("/android/party/mypartylist")
	public void mypartylist(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws IOException {
		
		System.out.println("mypartylist() 에 접근함");
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();

		//		
		String member_id = req.getParameter("member_id");
		
		try {
			
			List<PartyListVO> list = new ArrayList<PartyListVO>();
			list = pDAO.selectMypartyList(member_id);

			// 이걸 안드로이드에서 가져감 // vo = sql.selectOne("mainburger.mapper.selectThisVs");
			System.out.println(list.get(0).getParty_name());

			writer.print(gson.toJson(list));

		} catch (Exception e) {
			e.printStackTrace();
		}

		

	}//mypartylist()
	
	
	
	@ResponseBody
	@RequestMapping("/android/party/openpartylist")
	public void openpartylist(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws IOException {
		
		System.out.println("openpartylist() 에 접근함");
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();

		
//		String from_and_party_private = req.getParameter("party_private");
//		//vo = (ZZMemberVO) gson.fromJson(from_and_dto, ZZMemberVO.class);
//
//		System.out.println(from_and_party_private);	//안드 값 받아왔는지 찍을려고 테스트
		
		
				
		
		
		
		try {
			
			List<PartyListVO> list = new ArrayList<PartyListVO>();
			list = pDAO.selectOpenpartyList();
			System.out.println(list.get(0).getParty_name());

			writer.print(gson.toJson(list));

		} catch (Exception e) {
			e.printStackTrace();
		}

		

	}//openpartylist()
	
	
	@ResponseBody
	@RequestMapping("/android/party/partydetail")
	public void partyDetail(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws IOException {
		
		System.out.println("partyDetail() 에 접근함");
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();

		
		String from_and_party_sn= req.getParameter("party_sn");
		int party_sn = Integer.parseInt(from_and_party_sn);

						
		try {
			
			List<PartyListVO> list = new ArrayList<PartyListVO>();
			list = pDAO.selectPartyDetail(party_sn);
			
			writer.print(gson.toJson(list));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}//partyDetail()
	
	
	@ResponseBody
	@RequestMapping("/android/party/partyJoin")
	public void partyJoin(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws IOException {
		System.out.println("partyJoin() 메소드 접근");
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();

		PartyListVO vo = new PartyListVO();
		String from_and_dto = req.getParameter("dto");
		vo = (PartyListVO) gson.fromJson(from_and_dto, PartyListVO.class);
		System.out.println("넘어온 아이디 " +vo.getMember_id());

		/*
		 * vo.setBoard_class(req.getParameter("board_class")+""); list =
		 * sql.selectList("mainburgernotice.mapper.noticelist",vo);
		 */

		try {

			pDAO.insertJoinparty(vo);

			// 이걸 안드로이드에서 가져감 // vo = sql.selectOne("mainburger.mapper.selectThisVs");

			writer.print(gson.toJson(vo));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}//partyJoin()
	
	
	
	@ResponseBody
	@RequestMapping("/android/party/searchopenpartylist")
	public void searchOpenPartylist(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws IOException {
		
		System.out.println("searchOpenPartylist() 에 접근함");
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();
		String search_keyword = req.getParameter("search_keyword");
		
		
		try {
			
			List<PartyListVO> list = new ArrayList<PartyListVO>();
			list = pDAO.selectSearchOpenPartylist(search_keyword);
			

			writer.print(gson.toJson(list));

		} catch (Exception e) {
			e.printStackTrace();
		}

		

	}//searchOpenPartylist()
	
	
	@ResponseBody
	@RequestMapping("/android/party/checkpartyname")
	public void checkPartyname(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws IOException {
		
		System.out.println("checkPartyname() 에 접근함");
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();
		String party_name = req.getParameter("party_name");
		
		try {
						
			String check = pDAO.selectcheckPartyname(party_name);			

			writer.print(check);

		} catch (Exception e) {
			e.printStackTrace();
		}

		

	}//checkpartyname()
	
	
	//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ         파티 플랜 영역			 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ         파티 플랜 영역			 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	
	
	
	
	@ResponseBody
	@RequestMapping("/android/party/insertplan")	
	public void insertPartyPlan(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws IOException {
		int succ = 0 ;
		System.out.println("insertPartyPlan 메소드 접근");
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();

		PartyPlanListVO vo = new PartyPlanListVO();
		String from_and_dto = req.getParameter("dto");
		vo = (PartyPlanListVO) gson.fromJson(from_and_dto, PartyPlanListVO.class);	

		try {

			succ = pDAO.insertPartyPlan(vo);
			System.out.println(succ);

			writer.print(succ);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}//insertParty

	
	
	@ResponseBody
	@RequestMapping("/android/party/planlist")
	public void selectPlanList(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws IOException {
		
		System.out.println("planlist() 에 접근함");
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();

		//		
		int party_sn = Integer.parseInt(req.getParameter("party_sn"));
		
		try {
			
			List<PartyPlanListVO> list = new ArrayList<PartyPlanListVO>();
			list = pDAO.selectPlanList(party_sn);

			writer.print(gson.toJson(list));

		} catch (Exception e) {
			e.printStackTrace();
		}

		

	}//mypartylist()
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}//PartyController()

