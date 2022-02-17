package android.chaminhwan;

public class ReplyVO {
    int reply_sn, board_sn;
    String reply_content, member_id, picture_filepath;

    public String getPicture_filepath() {
        return picture_filepath;
    }

    public void setPicture_filepath(String picture_filepath) {
        this.picture_filepath = picture_filepath;
    }

    public int getReply_sn() {
        return reply_sn;
    }
    public void setReply_sn(int reply_sn) {
        this.reply_sn = reply_sn;
    }
    public int getBoard_sn() {
        return board_sn;
    }
    public void setBoard_sn(int board_sn) {
        this.board_sn = board_sn;
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
}
