package com.hanul.tot.and;

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

import com.google.gson.Gson;

import android.chaminhwan.MbtiVO;
import android.mainburger.BoardCommonVO;
import common.TempDAO;

@Controller
public class MbtiController {
	Gson gson = new Gson();

	@Autowired
	@Qualifier("cteam")
	private SqlSession sql;

	int i = 0;

	@RequestMapping("/android/cmh/mbti_*/")
	public void mbtiMatch(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws IOException {
		i++;
		String path = req.getServletPath();
		System.out.println("\n 테스트 : " + i + "\n" + path);
		System.out.println("getServletPath : " + path);

		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();

		MbtiVO vo = new MbtiVO();
		vo = gson.fromJson(req.getParameter("mbtiVO"), MbtiVO.class);
		System.out.println(vo);

		List<BoardCommonVO> list = new ArrayList<BoardCommonVO>();

		/* ========================= if ========================= */
		/* ==================== 성향추천 요청시 ==================== */
		if (path.equals("/android/cmh/mbti_mbti/")) {
			try {
				list = sql.selectList("mbti.mapper.mbtimbti");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} /* ==================== 거리추천 요청시 ==================== */
		else if (path.equals("/android/cmh/mbti_xy/")) {
			try {
				list = sql.selectList("mbti.mapper.mbtixy");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("==========");
			System.out.println("요청 오류");
			System.out.println("==========");
		} /* ======================================================== */

		writer.print(gson.toJson(list));
	}
}
