package category;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import picture.PictureVO;

@Repository
public class CategoryDAO {
	
	@Autowired @Qualifier("cteam") private SqlSession sql;
	
	public List<CategoryVO> catetour_list() {
		
		return sql.selectList("category.mapper.tour_list");
	}
	
	public void reply_insert(CategoryVO category) {
		sql.insert("category.mapper.reply_insert", category);
	}
	public void reply_picture_insert(ArrayList<PictureVO> picture) {
		sql.insert("category.mapper.reply_picture", picture );
	}
}
	

