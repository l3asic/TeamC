package category;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import category.PictureVO;

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
	
	public int reply_insert(ReplyVO replyVo) {
		return sql.insert("category.mapper.reply_insert", replyVo);
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
	
	public List<PictureVO> list_picture(int board_sn) {
		return sql.selectList("category.mapper.list_picture",board_sn);
	}
	
	public List<PictureVO> replyList_picture(int reply_sn) {
		return sql.selectList("category.mapper.replyList_picture",reply_sn);
	}
	
	public CategoryVO detail_categoryBoard(CategoryVO categoryVO) {
		return sql.selectOne("category.mapper.detail_categoryBoard_one",categoryVO);
	}
	
	
	public List<ReplyVO> list_reviewpath(int board_sn) {
		return sql.selectList("category.mapper.list_reviewpath",board_sn);
	}
	
	public int category_like(int board_sn) {
		return sql.selectOne("category.mapper.category_like",board_sn);
	}
	
	
	public void like_insert(CategoryVO categoryVO) {
		sql.insert("category.mapper.like_insert", categoryVO );
	}
	
	public void like_delete(CategoryVO categoryVO) {
		sql.insert("category.mapper.like_delete", categoryVO );
	}
	
	public void deliteReply(int reply_sn) {
		sql.delete("category.mapper.deliteReply" , reply_sn ) ;
	}
	

}
	

