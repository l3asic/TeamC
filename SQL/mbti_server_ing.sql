SELECT top100.* , (
        SELECT COUNT(*)
        FROM tbl_board board,tbl_likes likes
        WHERE board.board_sn = likes.board_sn AND likes.function_like IS NOT NULL AND likes.board_sn = top100.board_sn
    ) "좋아요 수" ,  (
        SELECT COUNT(*)
        FROM tbl_board board, tbl_reply reply
        WHERE board.board_sn = reply.board_sn AND reply.board_sn = top100.board_sn
    ) "댓글수"
FROM
    ( SELECT ROWNUM, mbti.* 
    FROM 
        ( SELECT   board.*,
                    abs(a.mbti_activity - b.mbti_activity) + abs(a.mbti_festival - b.mbti_festival) + abs(a.mbti_tour - b.mbti_tour) +
                    abs(a.mbti_solo - b.mbti_solo) + abs(a.mbti_couple - b.mbti_couple) + abs(a.mbti_buddys - b.mbti_buddys) + abs(a.
                    mbti_family - b.mbti_family) + abs(a.mbti_price - b.mbti_price) + abs(a.mbti_sd - b.mbti_sd) + abs(a.mbti_io - b.
                    mbti_io) AS matchscore
            FROM
                    ( SELECT *
                        FROM tbl_mbti
                        WHERE member_id = 'ChaMinHwan'
                    ) a,
                    ( SELECT *
                        FROM tbl_mbti
                        WHERE member_id IS NULL
                    ) b,
                tbl_board board
                WHERE board.board_sn = b.board_sn
                ORDER BY matchscore
            ) mbti
  --      WHERE ROWNUM <= 100
        ORDER BY dbms_random.value( 1, 1000 )
    ) top100
-- WHERE ROWNUM <= 10
ORDER BY matchscore;
    
--
commit;
--

SELECT
    *
FROM
    tbl_mbti
WHERE
    board_sn IS NULL;
    
-- 차민환ㅄ
SELECT
    COUNT(*)
FROM
    tbl_board board,
    tbl_reply reply
WHERE
    board.board_sn = reply.board_sn
    AND reply.board_sn = 377;
      
      
-- 377번 게시물 좋아요수, 댓글 수 가져오기    
SELECT
    *
FROM
    (
        SELECT
            COUNT(*)
        FROM
            tbl_board board,
            tbl_likes likes
        WHERE
            board.board_sn = likes.board_sn
            AND likes.function_like IS NOT NULL
            AND likes.board_sn = 377
    ),
    (
        SELECT
            COUNT(*)
        FROM
            tbl_board board,
            tbl_reply reply
        WHERE
            board.board_sn = reply.board_sn
            AND reply.board_sn = 377
    );
--
--
SELECT
    COUNT(*)
FROM
    tbl_board       board,
    tbl_member_info member
WHERE
    member.member_id = board.member_id
    AND board.member_id = 'ChaMinHwan';
      
      alter table tbl_like renameto
tbl_likes;

SELECT
    *
FROM
    tbl_likes;

COMMIT;

--
(SELECT
    *
FROM
    (
        SELECT
            COUNT(*)
        FROM
            tbl_board board,
            tbl_likes likes
        WHERE
            board.board_sn = likes.board_sn
            AND likes.function_like IS NOT NULL
                AND likes.board_sn = 377
    ),
    (
        SELECT
            COUNT(*)
        FROM
            tbl_board board,
            tbl_reply reply
        WHERE
            board.board_sn = reply.board_sn
            AND reply.board_sn = top100.board_sn
    ) )
      