package common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import android.chaminhwan.MbtiVO;

@Repository
public class TempDAO {
	@Autowired
	@Qualifier("cteam")
	private SqlSession sql;
	public List<MbtiVO> mbtiMatch(List<MbtiVO> list) {
		MbtiVO vo = new MbtiVO();
		for (int i = 1; i < list.size(); i++) {
list.get(i).setMbti_tour(list.get(0).getMbti_tour() + list.get(i).getMbti_tour()); 
list.get(i).setMbti_activity(list.get(0).getMbti_activity() + list.get(i).getMbti_activity()); 
list.get(i).setMbti_festival(list.get(0).getMbti_festival() + list.get(i).getMbti_festival()); 
list.get(i).setMbti_solo(list.get(0).getMbti_solo() + list.get(i).getMbti_solo()); 
list.get(i).setMbti_couple(list.get(0).getMbti_couple() + list.get(i).getMbti_couple()); 
list.get(i).setMbti_buddy(list.get(0).getMbti_buddy() + list.get(i).getMbti_buddy()); 
list.get(i).setMbti_family(list.get(0).getMbti_family() + list.get(i).getMbti_family()); 
list.get(i).setMbti_price(list.get(0).getMbti_price() + list.get(i).getMbti_price()); 
list.get(i).setMbti_sd(list.get(0).getMbti_sd() + list.get(i).getMbti_sd()); 
list.get(i).setMbti_io(list.get(0).getMbti_io() + list.get(i).getMbti_io()); 

			
		}

		return list;

	}


}
