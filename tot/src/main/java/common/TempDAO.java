package common;

import java.util.Random;

import org.apache.ibatis.ognl.ASTThisVarRef;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import common.TempDAO.ParamIntVO;

public class TempDAO {
	

	
	
	
	static class ParamIntVO {
		int pn0, pn1, pn2, pn3, pn4, pn5, pn6, pn7, pn8, pn9;

		public int getPn0() {
			return pn0;
		}

		public void setPn0(int pn0) {
			this.pn0 = pn0;
		}

		public int getPn1() {
			return pn1;
		}

		public void setPn1(int pn1) {
			this.pn1 = pn1;
		}

		public int getPn2() {
			return pn2;
		}

		public void setPn2(int pn2) {
			this.pn2 = pn2;
		}

		public int getPn3() {
			return pn3;
		}

		public void setPn3(int pn3) {
			this.pn3 = pn3;
		}

		public int getPn4() {
			return pn4;
		}

		public void setPn4(int pn4) {
			this.pn4 = pn4;
		}

		public int getPn5() {
			return pn5;
		}

		public void setPn5(int pn5) {
			this.pn5 = pn5;
		}

		public int getPn6() {
			return pn6;
		}

		public void setPn6(int pn6) {
			this.pn6 = pn6;
		}

		public int getPn7() {
			return pn7;
		}

		public void setPn7(int pn7) {
			this.pn7 = pn7;
		}

		public int getPn8() {
			return pn8;
		}

		public void setPn8(int pn8) {
			this.pn8 = pn8;
		}

		public int getPn9() {
			return pn9;
		}

		public void setPn9(int pn9) {
			this.pn9 = pn9;
		}

	}


	@Autowired
	@Qualifier("cteam")
	private SqlSession sql;
	public  void insertRandomMbti() {
	
		Random random = new Random();
		ParamIntVO vo = new ParamIntVO();
		
		for (int i = 0; i < 1000; i++) {
			
			vo.setPn0(random.nextInt(5));
			vo.setPn1(random.nextInt(5));
			vo.setPn2(random.nextInt(5));
			vo.setPn3(random.nextInt(5));
			vo.setPn4(random.nextInt(5));
			vo.setPn5(random.nextInt(5));
			vo.setPn6(random.nextInt(5));
			vo.setPn7(random.nextInt(5));
			vo.setPn8(random.nextInt(5));
			vo.setPn9(random.nextInt(5));

			sql.insert("temp.mapper.randommbti", vo);
		}



	}

	

}
