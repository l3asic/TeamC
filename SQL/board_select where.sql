SELECT
    ROWNUM,
    tbl.* 
	from (select * from tbl_board 
	where board_class = 'notice' and nvl(member_id,'ERRORERRORERROR') = 'ChaMinHwan'
	order by board_sn desc ) tbl  
where rownum  <= 10 order by ROWNUM;

SELECT
    ROWNUM,
    tbl.* 
	from (select * from tbl_board 
	where board_class = 'notice' and nvl(member_id,'ERRORERRORERROR') = null
	order by board_sn desc ) tbl  
where rownum  <= 10 order by ROWNUM;


SELECT
    ROWNUM,
    tbl.* 
	from (select * from tbl_board 
	where board_class = 'notice' and member_id is 'ChaMinHwan'
	order by board_sn desc ) tbl  
where rownum  <= 10 order by ROWNUM;

