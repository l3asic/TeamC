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
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import android.chaminhwan.MbtiVO;
import android.mainburger.BoardCommonVO;
import common.TempDAO;
import login.TendVO;

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

		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();

		String member_id;
		member_id = req.getParameter("member_id");

		if (member_id == null) {
			member_id = null;
		}

		MbtiVO vo = new MbtiVO();

		List<BoardCommonVO> list = new ArrayList<BoardCommonVO>();

		/* ========================= if ========================= */
		/* ==================== 성향추천 요청시 ==================== */
		if (path.equals("/android/cmh/mbti_mbti/")) {
			List<TendVO> mbti_check = new ArrayList<TendVO>();

			// 로그인 상태라면
			if (member_id != null) {
				try {
					mbti_check = sql.selectList("mbti.mapper.mbti_check", member_id);
				} catch (Exception e) {
					// TODO: handle exception
				}

				// 로그인하고 성향입력했다면
				if (mbti_check.size() != 0) {
					try {
						list = sql.selectList("mbti.mapper.mbtimbti", member_id);
						System.out.println("로그인 한상태임, 성향있음");

					} catch (Exception e) {
						e.printStackTrace();
					}

					// 회원인데 성향검사를 안했다면 랜덤 추천
				} else {
					try {
						list = sql.selectList("mbti.mapper.mbtiRandom");
						System.out.println("회원임, 성향x");
					} catch (Exception e) {
						e.printStackTrace();
					}

				}

				// 비회원일시 성향추천
			} else {
				try {
					list = sql.selectList("mbti.mapper.mbtiRandom");
					System.out.println("비회원임");
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			/* ==================== 거리추천 요청시 ==================== */
		} else if (path.equals("/android/cmh/mbti_xy/")) {

			if (member_id != null) {
				List<TendVO> mbti_check = new ArrayList<TendVO>();
				mbti_check = sql.selectList("mbti.mapper.mbti_check", member_id);
				if (mbti_check.size() != 0) {
					try {
						list = sql.selectList("mbti.mapper.mbtixy", member_id);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					try {
						list = sql.selectList("mbti.mapper.mbtiRandom");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				// 비회원일시 랜덤 추천
			} else {
				try {
					list = sql.selectList("mbti.mapper.mbtiRandom");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} else {
			System.out.println("==========");
			System.out.println("요청 오류");
			System.out.println("==========");
		} /* ======================================================== */

		writer.print(gson.toJson(list));
	}



	
	
	
	
	
	
	
	
	







}
