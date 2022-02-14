select  top100.*
from (
   select rownum, mbti.* from(
    select  board.*, abs(a.mbti_activity - b.mbti_activity) +
    abs(a.mbti_festival- b.mbti_festival)+
    abs(a.mbti_tour- b.mbti_tour)+
    abs(a.mbti_solo- b.mbti_solo)+
    abs(a.mbti_couple- b.mbti_couple)+
    abs(a.mbti_buddys- b.mbti_buddys)+
    abs(a.mbti_family- b.mbti_family)+
    abs(a.mbti_price- b.mbti_price)+
    abs(a.mbti_sd- b.mbti_sd)+
    abs(a.mbti_io- b.mbti_io) as matchscore
    from (select * from tbl_mbti where member_id='ChaMinHwan') a ,(select * from tbl_mbti where member_id is null) b ,tbl_board board  where  board.board_sn = b.board_sn
    order by matchscore asc
    ) mbti where rownum<=  100  order by DBMS_RANDOM.VALUE(1,1000 ) 
      ) top100 where rownum  <=  10;