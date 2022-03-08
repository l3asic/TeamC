package android.chaminhwan;

import java.io.Serializable;

public class ReplyVO implements Serializable {

	private int reply_sn, board_sn;
	private String reply_content;
	private String member_id;
	private String picture_filepath;
	private String reply_writedate;

	public int getReply_sn() {
		return reply_sn;
	}

	public String getReply_content() {
		return reply_content;
	}

	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getPicture_filepath() {
		return picture_filepath;
	}

	public void setPicture_filepath(String picture_filepath) {
		this.picture_filepath = picture_filepath;
	}

	public String getReply_writedate() {
		return reply_writedate;
	}

	public void setReply_writedate(String reply_writedate) {
		this.reply_writedate = reply_writedate;
	}

}
