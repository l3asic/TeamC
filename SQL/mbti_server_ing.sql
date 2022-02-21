--성향기준
SELECT top100.* , (
        SELECT COUNT(*)
        FROM tbl_board board,tbl_likes likes
        WHERE board.board_sn = likes.board_sn AND likes.function_like IS NOT NULL AND likes.board_sn = top100.board_sn
    ) "좋아요 수" ,  (
        SELECT COUNT(*)
        FROM tbl_board board, tbl_reply reply
        WHERE board.board_sn = reply.board_sn AND reply.board_sn = top100.board_sn
    ) "댓글수" , ( SELECT picture.picture_filepath
        FROM tbl_board board, tbl_board_picture picture
        WHERE board.board_sn = picture.board_sn AND picture.board_sn = top100.board_sn) "파일패스"
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
        WHERE ROWNUM <= 100
        ORDER BY dbms_random.value( 1, 1000 )
    ) top100
 WHERE ROWNUM <= 100
ORDER BY matchscore;
--
select board.* from tbl_board board, tbl_mbti mbti where board.board_sn = mbti.board_sn;
--ㅋㅋ시발 
  SELECT likes.*
        FROM tbl_board board,tbl_likes likes
        WHERE board.board_sn = likes.board_sn AND likes.board_sn = 1001;

select * from tbl_likes where board_sn = 360;

   SELECT *
        FROM tbl_board board, tbl_reply reply
        WHERE board.board_sn = reply.board_sn 
        ;
        
        SELECT *
        FROM tbl_board board,tbl_likes likes
        WHERE board.board_sn = likes.board_sn ;
--

--거리기준
SELECT top100.* , (
        SELECT COUNT(*)
        FROM tbl_board board,tbl_likes likes
        WHERE board.board_sn = likes.board_sn AND likes.function_like IS NOT NULL AND likes.board_sn = top100.board_sn
    ) "좋아요 수" ,  (
        SELECT COUNT(*)
        FROM tbl_board board, tbl_reply reply
        WHERE board.board_sn = reply.board_sn AND reply.board_sn = top100.board_sn
    ) "댓글수" , ( SELECT picture.picture_filepath
        FROM tbl_board board, tbl_board_picture picture
        WHERE board.board_sn = picture.board_sn AND picture.board_sn = top100.board_sn) "파일패스"
FROM
    ( SELECT ROWNUM, mbti.* 
    FROM 
        ( SELECT   board.*,
                    abs(a.mbti_x - b.mbti_x) + abs(a.mbti_y - b.mbti_y)  AS matchscore
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
        WHERE ROWNUM <= 100
        ORDER BY dbms_random.value( 1, 1000 )
    ) top100
 WHERE ROWNUM <= 10
ORDER BY matchscore;
--

commit;