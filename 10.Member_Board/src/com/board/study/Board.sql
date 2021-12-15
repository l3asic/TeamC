-- 테이블 생성
create table memberBoard(
   board_num number primary key not null,
   board_id varchar2(15),
   board_subject varchar2(50),
   board_content varchar2(2000),
   board_file varchar2(20),
   board_re_ref number,
   board_re_lev number,
   board_re_seq number,
   board_readcount number,
   board_date date
);

-- 전체레코드 조회
select * from memberBoard;

-- 제약조건 설정
alter table memberBoard
  add constraint pk_board_id foreign key(Board_id)
    references boardMember(Member_id)
      on delete cascade;
      
-- 제약조건 해제
alter table memberBoard
  drop constraint pk_board_id;