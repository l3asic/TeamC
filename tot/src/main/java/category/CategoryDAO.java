package category;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;



@Repository
public class CategoryDAO {
	
	@Autowired @Qualifier("cteam") private SqlSession sql;
	
	public List<CategoryVO> catetour_list() {
		return sql.selectList("category.mapper.categoryList_tour");
	}
	public List<CategoryVO> cateact_list() {
		return sql.selectList("category.mapper.categoryList_activity");
	}
	public List<CategoryVO> catefes_list() {
		return sql.selectList("category.mapper.categoryList_festival");
	}
	
	public void reply_insert(CategoryVO category) {
		sql.insert("category.mapper.reply_insert", category);
	}
	public void reply_picture_insert(ArrayList<PictureVO> picture) {
		sql.insert("category.mapper.reply_picture", picture );
	}
	
//	public List<CategoryVO> detail_tour(){
//		return sql.selectOne("category.mapper.detail_List");
//	}
	
	public List<CategoryVO> detail_categoryBoard() {
		return sql.selectOne("category.mapper.detail_categoryBoard");
	}
}
	

