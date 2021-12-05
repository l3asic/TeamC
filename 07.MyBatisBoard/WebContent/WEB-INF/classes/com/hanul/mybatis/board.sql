-- 테이블 생성
create table tblBoard(
  b_num       number primary key not null,
  b_subject   varchar2(50),
  b_pwd       varchar2(20),
  b_content   varchar2(2000),
  b_writer    varchar2(20),
  b_date      varchar2(20),
  b_readcount number
);

-- 전체레코드 검색
select * from tblBoard order by b_num desc;

-- 자동증가값 설정 : b_num → b_num_seq 변수
create sequence b_num_seq start with 1;

-- 임의의 레코드 삽입
insert into tblBoard(b_num, b_subject, b_pwd, b_content, b_writer, b_date, b_readcount)
  values(b_num_seq.nextval, 'subject', 'pwd', 'content', 'writer', sysdate, 0);

-- 커밋
commit;

-- 전체레코드 삭제
delete from tblBoard;

-- 테이블 제거
drop table tblBoard;

-- 자동증가값 제거
drop sequence b_num_seq;
