package category;

import java.io.Serializable;
import java.util.Date;

public class FavoritesVO {
	private int BOARD_SN;
	private String MEMBER_ID;
	private int FUNCTION_LIKE;
	
	public int getBOARD_SN() {
		return BOARD_SN;
	}
	public void setBOARD_SN(int bOARD_SN) {
		BOARD_SN = bOARD_SN;
	}
	public String getMEMBER_ID() {
		return MEMBER_ID;
	}
	public void setMEMBER_ID(String mEMBER_ID) {
		MEMBER_ID = mEMBER_ID;
	}
	public int getFUNCTION_LIKE() {
		return FUNCTION_LIKE;
	}
	public void setFUNCTION_LIKE(int fUNCTION_LIKE) {
		FUNCTION_LIKE = fUNCTION_LIKE;
	}
	
	
	
}
