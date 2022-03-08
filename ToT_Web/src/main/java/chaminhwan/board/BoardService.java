package chaminhwan.board;

import java.util.List;



public interface BoardService {

	int board_insert(BoardVO vo); // 방명록 글 신규 저장 (C)
//
	List<BoardVO> board_list(BoardVO boardVO );// 방명록 목록 조회 - 페이지 처리된 (R)
//
	BoardVO board_detail(int board_sn); // 방명록 상세 조회 (R)
//
//	int board_read(int id); // 방명록 조회수 처리 (U)
//
	int board_update(BoardVO boardVO); // 방명록 글 변경 저장 (U)
//
	int board_delete(int board_sn); // 방명록 글 삭제 (D)
//
	int board_comment_insert(ReplyVO replyVO); // 방명록 댓글 신규저장 처리
//
	int reply_update(ReplyVO replyVO); // 방명록 댓글 변경저장 처리
//
	int reply_delete(int reply_sn); // 방명록 댓글 삭제 처리
//
	List<ReplyVO> reply_list(ReplyVO replyVO); // 방명록 댓글 목록 조회
	// pid : 원 글의 id

}
