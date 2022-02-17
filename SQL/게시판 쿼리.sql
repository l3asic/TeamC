
--377번 게시물의 댓글내용, 해당 댓글작성자들의 파일패스
select reply.* , (select picture.picture_filepath from tbl_board_picture picture where picture.member_id = reply.member_id) filepath
from tbl_reply reply where board_sn = 377;
--

select * from tbl_board_picture where member_id = 'ChaMinHwan';

insert into tbl_reply values (9,'차민환이쓴댓글', 377, 'ChaMinHwan')
;
select * from tbl_reply;

commit;

select * from tbl_board_picture where board_sn = 377;

select * from tbl_board_picture where member_id = '1111';


select * from tbl_reply where member_id='1111';
--
select picture.picture_filepath from tbl_board_picture picture, tbl_reply reply where picture.member_id = '1111' and reply.member_id =picture.member_id;

select * from tbl_board_picture;


select * from tbl_board where board_title = '댓글 테스트용 공지';

select * from tbl_reply where board_sn = 1001;