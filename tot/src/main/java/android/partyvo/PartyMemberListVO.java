package android.partyvo;

public class PartyMemberListVO {
    private String member_id;
    private String picture_filepath;

    

    public String getMemberid() {
        return member_id;
    }

    public void setMemberid(String memberid) {
        this.member_id = memberid;
    }

    public String getPicture_filepath() {
        return picture_filepath;
    }

    public void setPicture_filepath(String picture_filepath) {
        this.picture_filepath = picture_filepath;
    }
}
