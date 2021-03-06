package chaminhwan.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO implements BoardService {

	@Autowired
	@Qualifier("cteam")
	SqlSession sql;

	@Override
	public int board_insert(BoardVO vo) {
		return sql.insert("board.mapper.insert", vo);
	}

	@Override
	public List<BoardVO> board_list(BoardVO boardVO) {
		// 전체 게시글 수 조회3
		
//		int pagecnt = sql.selectOne("notice.mapper.totalList", page);
//		page.setTotalList(pagecnt);
		
//		page.setTotalList(sql.selectOne("board.mapper.totalList", page));
		
//		int pageCnt = sql.selectOne("board.mapper.totalList",page);
//		page.setTotalList(pageCnt);
		
		// 페이징 처리된 전체 게시글 목록 조회
//		List<NoticeVO> list =  sql.selectList("notice.mapper.list", page);
//		page.setList(list); // 조회된 값을 리튼
		
//		List<BoardVO> list =  sql.selectList("board.mapper.list", page);
//		page.setList(list);
		List<BoardVO> list = sql.selectList("board.mapper.list",boardVO);
		
		return list;
	}
//
	@Override
	public BoardVO board_detail(int board_sn) {
		sql.update("board.mapper.read", board_sn);
		return sql.selectOne("board.mapper.detail", board_sn);
	}
//
//	@Override
//	public int board_read(int id) {
//		return sql.update("board.mapper.read", id);
//	}
//
	@Override
	public int board_update(BoardVO boardVO) {
		return sql.update("board.mapper.update", boardVO);
	}
//
	@Override
	public int board_delete(int board_sn) {
		return sql.delete("board.mapper.delete", board_sn);
	}
//
	@Override
	public int board_comment_insert(ReplyVO replyVO) {
		return sql.insert("board.mapper.reply_insert", replyVO);
	}
//
	@Override
	public int reply_update(ReplyVO replyVO) {
		// TODO Auto-generated method stub
		return sql.update("board.mapper.comment_update", replyVO);
	}
//
	@Override
	public int reply_delete(int reply_sn) {
		// TODO Auto-generated method stub
		return sql.delete("board.mapper.comment_delete",reply_sn);
	}
//
	@Override
	public List<ReplyVO> reply_list(ReplyVO replyVO) {
		// TODO Auto-generated method stub
		return sql.selectList("board.mapper.reply_list", replyVO);
	}

}
