-- 테이블 생성
create table boardMember(
   member_id varchar2(15) primary key not null,
   member_pw varchar2(15),
   member_name varchar2(15),
   member_age number,
   member_gender varchar2(5),
   memebr_email varchar2(30)
);

-- 전체레코드 검색
select * from boardMember;