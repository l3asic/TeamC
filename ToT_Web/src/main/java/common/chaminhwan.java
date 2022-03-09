package common;

import java.net.http.HttpResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import member.MemberVO;

public class chaminhwan {
	public static int cnt = 0;

	// ================ 로그인 안돼있으면 홈으로 돌려버림
	public static boolean isLoginedCheck(HttpSession session) {
		MemberVO vo = (MemberVO) session.getAttribute("loginInfo");
		if (vo == null) {
			System.out.println("로그인체크 - X");
			return false;
		} else {
			System.out.println("로그인체크 - O");
			return true;
		}
	}//=================================================

	//================== path 출력하는거 귀찮아서 여기써놓음
	public static void printPath(HttpServletRequest req) {
		String path = req.getServletPath();
		System.out.println(path);
	}//==================================================

}
