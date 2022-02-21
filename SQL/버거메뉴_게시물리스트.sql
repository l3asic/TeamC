--내가쓴글 리스트 조회
SELECT
    boards.*,
    (
        SELECT
            COUNT(*)
        FROM
            tbl_board board,
            tbl_likes likes
        WHERE
                board.board_sn = likes.board_sn
        --    AND likes.function_like IS NOT NULL
            AND likes.board_sn = boards.board_sn
    ) "좋아요",
    (
        SELECT
            COUNT(*)
        FROM
            tbl_board board,
            tbl_reply reply
        WHERE
                board.board_sn = reply.board_sn
            AND reply.board_sn = boards.board_sn
    ) "댓글 수"
FROM
    (
        SELECT
            *
        FROM
            tbl_board
        WHERE
            member_id = 'ChaMinHwan'
    ) boards;


--좋아요 누른 게시물 리스트 조회
SELECT
    boards.*,
    (
        SELECT
            COUNT(*)
        FROM
            tbl_board board,
            tbl_likes likes
        WHERE
                board.board_sn = likes.board_sn
           -- AND likes.function_like IS NOT NULL
            AND likes.board_sn = boards.board_sn
    ) "좋아요",
    (
        SELECT
            COUNT(*)
        FROM
            tbl_board board,
            tbl_reply reply
        WHERE
                board.board_sn = reply.board_sn
            AND reply.board_sn = boards.board_sn
    ) "댓글 수"
FROM
    (
        SELECT
            board.*
        FROM
            tbl_board board,
            tbl_likes likes
        WHERE
                board.board_sn = likes.board_sn
            AND likes.member_id = 'ChaMinHwan'
    ) boards;

--
--