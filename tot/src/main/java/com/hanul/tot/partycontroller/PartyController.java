package com.hanul.tot.partycontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import android.mainburger.MainBurgerNoticeVO;
import android.partydao.PartyListDAO;
import android.partyvo.PartyListVO;
import android.partyvo.ZZMemberVO;

@Controller
public class PartyController {
	Gson gson = new Gson();
	@Autowired
	PartyListDAO plDAO;

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

			plDAO.insertParty(vo);

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
			list = plDAO.selectMypartyList(member_id);

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
			list = plDAO.selectOpenpartyList();
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

		System.out.println(party_sn);	//안드 값 받아왔는지 찍을려고 테스트
		
		
				
		try {
			
			List<PartyListVO> list = new ArrayList<PartyListVO>();
			list = plDAO.selectPartyDetail(party_sn);
			System.out.println("party_sn = " + list.get(0).getParty_sn() );
			System.out.println("0번째 멤버" + list.get(0).getMember_id());
			

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

			plDAO.insertJoinparty(vo);

			// 이걸 안드로이드에서 가져감 // vo = sql.selectOne("mainburger.mapper.selectThisVs");

			writer.print(gson.toJson(vo));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}//partyJoin()
	


}//PartyController()












