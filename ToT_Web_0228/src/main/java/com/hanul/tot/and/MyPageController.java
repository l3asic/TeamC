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

import com.google.gson.Gson;

import chaminhwan.board.BoardPage;
import chaminhwan.board.BoardServiceImpl;
import chaminhwan.board.BoardVO;
import common.CommonService;
import common.chaminhwan;
import member.MemberVO;

@Controller
public class MyPageController {

	private static final Logger logger = LoggerFactory.getLogger(MyPageController.class);

	Gson gson = new Gson();
	@Autowired
	@Qualifier("cteam")
	SqlSession sql;

	@RequestMapping("/mypage_{member_id}")
	public String myPage(@PathVariable String member_id, Locale locale, HttpSession session, Model model,
			HttpServletRequest req, HttpServletResponse res) throws IOException {
		String path = req.getServletPath();

		int memberCheck = sql.selectOne("member.mapper.memberid_check", member_id);
		if (memberCheck > 0) {

			MemberVO memberVO = new MemberVO();
			memberVO = sql.selectOne("mypage.mapper.selectvo", member_id);

			model.addAttribute("path", "/mypage_");
			model.addAttribute("member_id", member_id);
			model.addAttribute("memberVO", memberVO);
		} else {
//			req.setCharacterEncoding("UTF-8");
//			res.setCharacterEncoding("UTF-8");
//			res.setContentType("text/html");
//			PrintWriter writer = res.getWriter();
////			writer.println("<html><body>");
////			writer.println("<script>alert('존재하지 않는 사용자입니다')");
////			writer.println("</body></html>");
//
//			writer.println("<script>");
//			writer.println("<script>alert('존재하지 않는 사용자입니다')");
//			writer.println("history.back()");
//			writer.println("</script>");
//			writer.flush();
			
			req.setCharacterEncoding("UTF-8");
			res.setCharacterEncoding("UTF-8");
			res.setContentType("text/html");
			PrintWriter writer = res.getWriter();
			writer.println("<html><body>");
			writer.println("<script>alert('존재하지 않는 사용자입니다.')");
			writer.println("history.back()</script>");
			writer.println("</body></html>");
		}
		return "zzchaminhwan04board/board_00_main";
	}

	@RequestMapping("/mypage_list_*")
	public String list(BoardVO vo, Locale locale, HttpSession session, Model model, HttpServletRequest req)
			throws IOException {
		String path = req.getServletPath();
		System.out.println(path);
		List<BoardVO> list = sql.selectList("mypage.mapper." + path, vo);
		model.addAttribute("boardVO", list);

		return "zzchaminhwan00mypage/mypage_00_list_stack";
	}
//======================================================================================================================
}
