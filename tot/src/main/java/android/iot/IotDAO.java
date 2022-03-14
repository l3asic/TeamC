package android.iot;

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
public class IotDAO {
	
	@Autowired
	@Qualifier("cteam")
	private SqlSession sql;
	
	
	public List<IotVO> selectSaveIot(IotVO vo) {
		
		return sql.selectList("iot.mapper.selectSaveIot", vo);
		
	}
	
	
	public void insertSaveIot(IotVO vo) {
		
		sql.insert("iot.mapper.insertSaveIot", vo);	
		
	}	
	
public void updateSaveIot(IotVO vo) {
		
		sql.update("iot.mapper.updateSaveIot", vo);	
		
	}

	
	

	
}// IotDAO();






