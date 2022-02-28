package category;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import category.ReplyVO;
import category.PictureVO;

@Repository
public class CategoryDAO {
	
	@Autowired @Qualifier("cteam") private SqlSession sql;
	
	/*☆☆☆원소스
	 * public List<CategoryVO> catetour_list() { return
	 * sql.selectList("category.mapper.categoryList_tour"); }
	 */
	
	/*
	 * public List<CategoryVO> catetour_list(CategoryPage page) { int pagecnt =
	 * sql.selectOne("category.mapper.totalList", page); page.setTotalList(pagecnt);
	 * 
	 * List<CategoryVO> list = sql.selectList("category.mapper.categoryList_tour",
	 * page); page.setList(list);
	 * 
	 * return page; }
	 * 
	 * 
	 */
	
	// 카테고리(관광지) 목록 조회 - 페이징 처리된 (R) 2022/02/26(추가)
	  public CategoryPage catetour_list(CategoryPage page ) {
		  // 전체 게시글 수 조회
		  int totalList = sql.selectOne("category.mapper.categoryList_tour_totalList", page);
		  page.setTotalList (totalList);
		  	
		  // 페이징 처리된 전체 게시글 조회
		  List<CategoryVO> list = sql.selectList("category.mapper.categoryList_tour", page);
		  page.setList(list);
		  return page;
	  }
	  
	  
	  
		/*☆☆원소스
		 * public List<CategoryVO> cateact_list() { return
		 * sql.selectList("category.mapper.categoryList_activity"); }
		 */
	  
	  public CategoryPage cateact_list(CategoryPage page ) {
		  // 전체 게시글 수 조회
		  int totalList = sql.selectOne("category.mapper.categoryList_activity_totalList", page);
		  page.setTotalList (totalList);
		  	
		  // 페이징 처리된 전체 게시글 조회
		  List<CategoryVO> list = sql.selectList("category.mapper.categoryList_activity", page);
		  page.setList(list);
		  return page;
	  }
	  
	  
		/* ☆☆원소스
		 * public List<CategoryVO> catefes_list() { return
		 * sql.selectList("category.mapper.categoryList_festival"); }
		 */
	  
	  public CategoryPage catefes_list(CategoryPage page ) {
		  // 전체 게시글 수 조회
		  int totalList = sql.selectOne("category.mapper.categoryList_festival_totalList", page);
		  page.setTotalList (totalList);
		  	
		  // 페이징 처리된 전체 게시글 조회
		  List<CategoryVO> list = sql.selectList("category.mapper.categoryList_festival", page);
		  page.setList(list);
		  return page;
	  }
	
	public int reply_insert(CategoryVO category) {
		return sql.insert("category.mapper.reply_insert", category);
	}
	public void reply_picture_insert(ArrayList<PictureVO> picture) {
		sql.insert("category.mapper.reply_picture", picture );
	}
	
	//★★ 웹 리플등록
	public int insert_reply(ReplyVO vo) {		
		return sql.insert("category.mapper.replyInsert", vo);
	}
	
//	public List<CategoryVO> detail_tour(){
//		return sql.selectOne("category.mapper.detail_List");
//	}
	
	public List<CategoryVO> detail_categoryBoard2(int board_sn) {
		return sql.selectOne("category.mapper.detail_categoryBoard");
	}
	
	public List<PictureVO> list_picture(int board_sn) {
		return sql.selectList("category.mapper.list_picture",board_sn);
	}
	
	public CategoryVO detail2_categoryBoard(CategoryVO categoryVO) {
		return sql.selectOne("category.mapper.detail_categoryBoard_one",categoryVO);
	}
	
	
	public List<CategoryVO> list_reviewpath(int board_sn) {
		return sql.selectList("category.mapper.list_reviewpath",board_sn);
	}
	
	public int category_like(int board_sn) {
		return sql.selectOne("category.mapper.category_like",board_sn);
	}
	
	
	public int like_insert(CategoryVO categoryVO) {
		return sql.insert("category.mapper.like_insert", categoryVO );
	}
	
	public int like_delete(CategoryVO categoryVO) {
		return sql.insert("category.mapper.like_delete", categoryVO );
	}
	
	public List<PictureVO> list_repicture(ReplyVO revo) {
		return sql.selectList("category.mapper.list_repicture",revo);
	}
	
	/*
	 * // 상세화면 출력 페이지 public CategoryVO detail_categoryBoard(int board_sn) { return
	 * sql.selectOne("category.mapper.detail_categoryBoards",board_sn); }
	 */
	
	// 상세화면 출력 페이지
	public CategoryVO detail_categoryBoard(CategoryVO vo) {
		return sql.selectOne("category.mapper.detail_categoryBoards",vo);
	}
	
	
	/*
	 * // 상세화면 출력 페이지( public CategoryVO detail_categoryBoard(CategoryVO vo) {
	 * return sql.selectOne("category.mapper.detail_categoryBoards",vo); }
	 */
	
	public int categoryLike_sn_member(CategoryVO categoryVO) {
		return sql.selectOne("category.mapper.categoryLike_sn_member",categoryVO);
	}
	
	public int reply_delete(ReplyVO reply) {
		return sql.delete("category.mapper.reply_delete", reply);
	}
	
}
	

