package category;

public class PictureVO {
	private String picture_filepath;
	private int board_sn, reply_sn, party_sn;
	private String member_id;

	public String getPicture_filepath() {
		return picture_filepath;
	}

	public void setPicture_filepath(String picture_filepath) {
		this.picture_filepath = picture_filepath;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public int getBoard_sn() {
		return board_sn;
	}

	public void setBoard_sn(int board_sn) {
		this.board_sn = board_sn;
	}

	public int getReply_sn() {
		return reply_sn;
	}

	public void setReply_sn(int reply_sn) {
		this.reply_sn = reply_sn;
	}

	public int getParty_sn() {
		return party_sn;
	}

	public void setParty_sn(int party_sn) {
		this.party_sn = party_sn;
	}
	
	
	
	
}
