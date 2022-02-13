select * from tbl_member_info order by member_id;



insert into tbl_member_info values ('KimWonKeun'	,'rladnjsrms' ,'근원김'	,'호준배', '여',	'010김원근010'	,'이메일' , 'master', '카카오', '네이버');

commit;



select * from tbl_party order by party_sn;

insert into tbl_party (party_sn, member_id, party_private, party_name) values(3, 'ChaMinHwan', 'y', '123');

select * from tbl_mbti;

select * from tbl_board where board_class = 'board' order by board_sn;

insert into tbl_board values (2, '게시판 제목456',  '차민환이 넣은 테스트 board_content', default, default, default, default, default, 'board', 'ChaMinHwan', null);

insert into tbl_board values (2, 'mbti테스트',  0, default, default, default, default, default, 'activity', 'ChaMinHwan', null);
insert into tbl_board values (3, 'mbti테스트',  0, default, default, default, default, default, 'festival', 'ChaMinHwan', null);
insert into tbl_board values (1, 'mbti테스트',  0, default, default, default, default, default, 'tour', 'ChaMinHwan', null);

insert into tbl_mbti values (0,'테스트','ChaMinHwan',null, '우리집', 65535,65535,1,1,1,3,1,1,1,1,1,1);
insert into tbl_mbti values (1,'테스트',null,101, 'addr', 65535,65535,5,1,1,5,5,5,5,5,5,5);
insert into tbl_mbti values (2,'테스트',null,102, 'addr', 65535,65535,1,5,1,4,4,4,4,4,4,4);

insert into tbl_mbti values (3,'테스트',null,1001, 'addr', 65535,65535,2,2,2,2,2,2,2,2,2,2);
insert into tbl_mbti values (3,'테스트',null,1001, 'addr', 65535,65535,2,2,2,2,2,2,2,2,2,2);
insert into tbl_mbti values (3,'테스트',null,1001, 'addr', 65535,65535,2,2,2,2,2,2,2,2,2,2);
insert into tbl_mbti values (3,'테스트',null,1001, 'addr', 65535,65535,2,2,2,2,2,2,2,2,2,2);
insert into tbl_mbti values (3,'테스트',null,1001, 'addr', 65535,65535,2,2,2,2,2,2,2,2,2,2);
insert into tbl_mbti values (3,'테스트',null,1001, 'addr', 65535,65535,2,2,2,2,2,2,2,2,2,2);
insert into tbl_mbti values (3,'테스트',null,1001, 'addr', 65535,65535,2,2,2,2,2,2,2,2,2,2);
insert into tbl_mbti values (3,'테스트',null,1001, 'addr', 65535,65535,2,2,2,2,2,2,2,2,2,2);
insert into tbl_mbti values (3,'테스트',null,1001, 'addr', 65535,65535,2,2,2,2,2,2,2,2,2,2);
insert into tbl_mbti values (3,'테스트',null,1001, 'addr', 65535,65535,2,2,2,2,2,2,2,2,2,2);

DBMS_RANDOM.VALUE(1,5 )

delete tbl_mbti where member_id is null;

commit;



select * from tbl_board order by board_sn;
select * from tbl_mbti;

select * from tbl_mbti where member_id= 'ChaMinHwan';

select * from tbl_mbti where member_id is null;

select * from tbl_mbti where member_id = 'ChaMinHwan' or member_id is null order by member_id;
select * from tbl_mbti where member_id = 'ChaMinHwan' or member_id is null order by member_id;

update TBL_mbti set 
mbti_activity =  0,
    mbti_festival =  0,
    mbti_tour =  0,
    mbti_solo =  0,
    mbti_couple =  0,
    mbti_buddys =  0,
    mbti_family =  0,
    mbti_price =  0,
    mbti_sd =  0,
    mbti_io =  0
where member_id = 'ChaMinHwan';
--
select *
    from(
    select rownum as rn1, c.* 
    from(
    select b.*, abs(a.mbti_activity+ b.mbti_activity) +
    abs(a.mbti_festival+ b.mbti_festival)+
    abs(a.mbti_tour+ b.mbti_tour)+
    abs(a.mbti_solo+ b.mbti_solo)+
    abs(a.mbti_couple+ b.mbti_couple)+
    abs(a.mbti_buddys+ b.mbti_buddys)+
    abs(a.mbti_family+ b.mbti_family)+
    abs(a.mbti_price+ b.mbti_price)+
    abs(a.mbti_sd+ b.mbti_sd)+
    abs(a.mbti_io+ b.mbti_io) as matchscore
    from (select * from tbl_mbti where member_id='ChaMinHwan') a ,(select * from tbl_mbti where member_id is null) b 
    order by matchscore) c
    where rownum <= 100
     order by DBMS_RANDOM.VALUE(1,500 )
    ) d
where rownum <=10
;





commit;
alter tABLE tbl_mbti MODIFY  (mbti_addr VISIBLE);
alter table tbl_mbti MODIFY (mbti_x VISIBLE);
alter tABLE tbl_mbti MODIFY  (mbti_y VISIBLE);
alter tABLE tbl_mbti MODIFY  (mbti_activity VISIBLE);
alter tABLE tbl_mbti MODIFY  (mbti_festival VISIBLE);
alter tABLE tbl_mbti MODIFY  (mbti_tour VISIBLE);
alter tABLE tbl_mbti MODIFY  (mbti_solo VISIBLE);
alter tABLE tbl_mbti MODIFY  (mbti_couple VISIBLE);
alter tABLE tbl_mbti MODIFY  (mbti_buddys VISIBLE);
alter tABLE tbl_mbti MODIFY  (mbti_family VISIBLE);
alter tABLE tbl_mbti MODIFY  (mbti_price VISIBLE);
alter tABLE tbl_mbti MODIFY  (mbti_sd VISIBLE);
alter tABLE tbl_mbti MODIFY  (mbti_io VISIBLE);
--
alter tABLE tbl_mbti MODIFY  (mbti_addr inVISIBLE);
alter table tbl_mbti MODIFY (mbti_x inVISIBLE);
alter tABLE tbl_mbti MODIFY  (mbti_y inVISIBLE);
alter tABLE tbl_mbti MODIFY  (mbti_activity inVISIBLE);
alter tABLE tbl_mbti MODIFY  (mbti_festival inVISIBLE);
alter tABLE tbl_mbti MODIFY  (mbti_tour inVISIBLE);
alter tABLE tbl_mbti MODIFY  (mbti_solo inVISIBLE);
alter tABLE tbl_mbti MODIFY  (mbti_couple inVISIBLE);
alter tABLE tbl_mbti MODIFY  (mbti_buddys inVISIBLE);
alter tABLE tbl_mbti MODIFY  (mbti_family inVISIBLE);
alter tABLE tbl_mbti MODIFY  (mbti_price inVISIBLE);
alter tABLE tbl_mbti MODIFY  (mbti_sd inVISIBLE);
alter tABLE tbl_mbti MODIFY  (mbti_io inVISIBLE);
--

alter table tbl_mbti modify column mbti_local after mbti_sn;
