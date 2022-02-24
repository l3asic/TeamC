package android.partydao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import android.kwk.MemberVO;
import android.partyvo.PartyListVO;
import android.partyvo.PartyMemberListVO;
import android.partyvo.PartyPlanListVO;
import android.partyvo.PlanInfoVO;

@Repository
public class PartyDAO {
	
	@Autowired
	@Qualifier("cteam")
	private SqlSession sql;
	public void insertParty(PartyListVO vo) {
		
		sql.insert("party.mapper.insertParty", vo);	
		
	}	

	
	public List<PartyListVO> selectMypartyList(String member_id) {
		
		return sql.selectList("party.mapper.selectMypartyList", member_id);
		
	}


	public List<PartyListVO> selectOpenpartyList() {
		
		return sql.selectList("party.mapper.selectOpenpartyList");
		
	}
	
	public List<PartyListVO> selectPartyDetail(int party_sn) {
		
		return sql.selectList("party.mapper.selectPartyDetail",party_sn);
		
	}


	public void insertJoinparty(PartyListVO vo) {
		
		sql.insert("party.mapper.insertJoinparty",vo);
		
	}


	public List<PartyListVO> selectSearchOpenPartylist(String search_keyword) {
		
		return sql.selectList("party.mapper.selectSearchOpenPartylist",search_keyword);
		
	}


	public String selectcheckPartyname(String party_name) {
		String check ;
		check = sql.selectOne("party.mapper.selectcheckPartyname", party_name);
		return check;
	}
	
	
	public int insertPartyPlan(PartyPlanListVO vo) {		
			
		return	sql.insert("party.mapper.insertPartyPlan", vo);
	}
	
	public int insertPartyPlanMembers(PartyPlanListVO vo) {		
		
		return	sql.insert("party.mapper.insertPartyPlanMembers", vo);
	}


	public List<PartyPlanListVO> selectPlanList(int party_sn) {
		
		return sql.selectList("party.mapper.selectPlanList", party_sn);
	}


	public List<PlanInfoVO> showPlanInfo(int plan_sn) {
		
		return sql.selectList("party.mapper.showPlanInfo", plan_sn);
	}


	public List<PlanInfoVO> planInfoDetail(PlanInfoVO vo) {
		
		return sql.selectList("party.mapper.planInfoDetail", vo);
		
	}


	public void insertPlanDetail(PlanInfoVO vo) {
		
		sql.insert("party.mapper.insertPlanDetail", vo);
		
	}


	public void updatePlanDetail(PlanInfoVO vo) {
		
		sql.update("party.mapper.updatePlanDetail", vo);
		
	}


	public void deletePlanList(PlanInfoVO vo) {
		
		sql.delete("party.mapper.deletePlanList", vo);
		
		
	}


	public void invitePartyMember(PartyListVO vo) {
		sql.insert("party.mapper.invitePartyMember", vo);		
	}


	public void deleteParty(PartyListVO vo) {
		sql.delete("party.mapper.deleteParty", vo);
		
	}


	public List<PartyMemberListVO> showPartyMember(PartyListVO vo) {

		return  sql.selectList("party.mapper.showPartyMember", vo);
	}


	public void deletePartyMember(PartyListVO vo) {
		
		sql.delete("party.mapper.deletePartyMember", vo);
		
	}


	public void updateParty(PartyListVO vo) {
		sql.update("party.mapper.updateParty", vo);
		
	}


	public List<PartyMemberListVO> planMemberList(int party_sn) {
		
		return sql.selectList("party.mapper.planMemberList", party_sn);
	}
	
	public List<PartyPlanListVO> selectPlanSn(String member_id) {
		
		return sql.selectList("party.mapper.selectPlanSn", member_id);
	}


	public void insertPartyPic(PartyListVO vo) {
		sql.insert("party.mapper.insertPartyPic", vo);		
	}


	public List<PartyListVO> selectPartySn(PartyListVO vo) {
		return sql.selectList("party.mapper.selectPartySn", vo);
		
	}


	public void updatePartyPic(PartyListVO vo) {
		sql.update("party.mapper.updatePartyPic", vo);
		
	}


	public List<PartyListVO> selectPartyList(int party_sn) {
		
		return sql.selectList("party.mapper.selectPartyList", party_sn);
	}


//	public List<PartyMemberListVO> selectPartyMemberList(int party_sn) {
//		
//		return sql.selectList("party.mapper.selectPartyMemberList", party_sn);
//	}


	

	
	
}//PartyDAO()






