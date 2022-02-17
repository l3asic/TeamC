package android.partydao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import android.partyvo.PartyListVO;
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


	public List<PartyPlanListVO> selectPlanList(int party_sn) {
		
		return sql.selectList("party.mapper.selectPlanList", party_sn);
	}


	public List<PlanInfoVO> showPlanInfo(int plan_sn) {
		
		return sql.selectList("party.mapper.showPlanInfo", plan_sn);
	}


	public List<PlanInfoVO> planInfoDetail(PlanInfoVO vo) {
		//sql.selectList(null, vo, null)	민환차가 하던거
		return sql.selectList("party.mapper.planInfoDetail", vo);
		
	}


	public void insertPlanDetail(PlanInfoVO vo) {
		sql.insert("party.mapper.insertPlanDetail", vo);
		
	}


	public void updatePlanDetail(PlanInfoVO vo) {
		sql.update("party.mapper.updatePlanDetail", vo);
		
	}


		

	
	
}//PartyDAO()






