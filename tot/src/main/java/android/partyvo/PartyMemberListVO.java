package android.partyvo;

public class PartyMemberListVO {
    private String member_id;
    private int picture_filepath;

    

    public String getMemberid() {
        return member_id;
    }

    public void setMemberid(String memberid) {
        this.member_id = memberid;
    }

    public int getPicture_filepath() {
        return picture_filepath;
    }

    public void setPicture_filepath(int picture_filepath) {
        this.picture_filepath = picture_filepath;
    }
}
