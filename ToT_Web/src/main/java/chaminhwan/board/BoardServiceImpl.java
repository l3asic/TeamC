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
//	@Override
//	public int board_update(BoardVO vo) {
//		return dao.board_update(vo);
//	}
//
	@Override
	public int board_delete(int board_sn) {
		return dao.board_delete(board_sn);
	}
//
//	@Override
//	public int board_comment_insert(BoardCommentVO vo) {
//		return dao.board_comment_insert(vo);
//	}
//
//	@Override
//	public int board_comment_update(BoardCommentVO vo) {
//		// TODO Auto-generated method stub
//		return dao.board_comment_update(vo);
//	}
//
//	@Override
//	public int board_comment_delete(int id) {
//		// TODO Auto-generated method stub
//		return dao.board_comment_delete(id);
//	}
//
//	@Override
//	public List<BoardCommentVO> board_comment_list(int pid) {
//		// TODO Auto-generated method stub
//		return dao.board_comment_list(pid);
//	}

}
