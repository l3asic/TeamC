package category;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class CategoryVO {
	private int board_sn,board_read_cnt, board_reviewpath, reply_sn, like_cnt;
    private String board_title, board_content, board_is_updated, board_private, board_reply_able,board_class, member_id;
    private String picture_filepath, member_nick, reply_content;
    private Date board_date_create, reply_writedate ;
    private int picture_file_count;
    private int board_cnt_reply, function_like;
    List<PictureVO> picList;
    private String member_filepath;
    
    
	public String getMember_filepath() {
		return member_filepath;
	}
	public void setMember_filepath(String member_filepath) {
		this.member_filepath = member_filepath;
	}
	public List<PictureVO> getPicList() {
		return picList;
	}
	public void setPicList(List<PictureVO> picList) {
		this.picList = picList;
	}
	public int getBoard_sn() {
		return board_sn;
	}
	public void setBoard_sn(int board_sn) {
		this.board_sn = board_sn;
	}
	public int getBoard_read_cnt() {
		return board_read_cnt;
	}
	public void setBoard_read_cnt(int board_read_cnt) {
		this.board_read_cnt = board_read_cnt;
	}
	
	
	public int getBoard_reviewpath() {
		return board_reviewpath;
	}
	public void setBoard_reviewpath(int board_reviewpath) {
		this.board_reviewpath = board_reviewpath;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public String getBoard_is_updated() {
		return board_is_updated;
	}
	public void setBoard_is_updated(String board_is_updated) {
		this.board_is_updated = board_is_updated;
	}
	public String getBoard_private() {
		return board_private;
	}
	public void setBoard_private(String board_private) {
		this.board_private = board_private;
	}
	
	
	public String getBoard_reply_able() {
		return board_reply_able;
	}
	public void setBoard_reply_able(String board_reply_able) {
		this.board_reply_able = board_reply_able;
	}
	public String getBoard_class() {
		return board_class;
	}
	public void setBoard_class(String board_class) {
		this.board_class = board_class;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	
	public Date getBoard_date_create() {
		return board_date_create;
	}
	public void setBoard_date_create(Date board_date_create) {
		this.board_date_create = board_date_create;
	}
	public String getPicture_filepath() {
		return picture_filepath;
	}
	public void setPicture_filepath(String picture_filepath) {
		this.picture_filepath = picture_filepath;
	}
	public int getPicture_file_count() {
		return picture_file_count;
	}
	public void setPicture_file_count(int picture_file_count) {
		this.picture_file_count = picture_file_count;
	}
	public int getBoard_cnt_reply() {
		return board_cnt_reply;
	}
	public void setBoard_cnt_reply(int board_cnt_reply) {
		this.board_cnt_reply = board_cnt_reply;
	}
	public int getFunction_like() {
		return function_like;
	}
	public void setFunction_like(int function_like) {
		this.function_like = function_like;
	}
	public String getMember_nick() {
		return member_nick;
	}
	public void setMember_nick(String member_nick) {
		this.member_nick = member_nick;
	}
	
	
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	public Date getReply_writedate() {
		return reply_writedate;
	}
	public void setReply_writedate(Date reply_writedate) {
		this.reply_writedate = reply_writedate;
	}
	public int getReply_sn() {
		return reply_sn;
	}
	public void setReply_sn(int reply_sn) {
		this.reply_sn = reply_sn;
	}
	public int getLike_cnt() {
		return like_cnt;
	}
	public void setLike_cnt(int like_cnt) {
		this.like_cnt = like_cnt;
	}
	
	
	
	
	
}
