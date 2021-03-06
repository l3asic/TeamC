package chaminhwan.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired private BoardDAO dao;

	@Override
	public int board_insert(BoardVO vo) {
		return dao.board_insert(vo);
	}

	@Override
	public List<BoardVO> board_list(BoardVO boardVO) {
		return dao.board_list(boardVO);
	}

	@Override
	public BoardVO board_detail(int board_sn) {
		return dao.board_detail(board_sn);
	}
//
//	@Override
//	public int board_read(int id) {
//		return dao.board_read(id);
//	}
//
	@Override
	public int board_update(BoardVO boardVO) {
		return dao.board_update(boardVO);
	}
//
	@Override
	public int board_delete(int board_sn) {
		return dao.board_delete(board_sn);
	}
//
	@Override
	public int board_comment_insert(ReplyVO replyVO) {
		return dao.board_comment_insert(replyVO);
	}
//
	@Override
	public int reply_update(ReplyVO replyVO) {
		// TODO Auto-generated method stub
		return dao.reply_update(replyVO);
	}
//
	@Override
	public int reply_delete(int reply_sn) {
		// TODO Auto-generated method stub
		return dao.reply_delete(reply_sn);
	}
//
	@Override
	public List<ReplyVO> reply_list(ReplyVO replyVO) {
		// TODO Auto-generated method stub
		return dao.reply_list(replyVO);
	}

}
