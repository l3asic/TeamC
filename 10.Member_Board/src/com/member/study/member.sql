-- 테이블 생성
create table boardMember(
   member_id varchar2(15) primary key not null,
   member_pw varchar2(15),
   member_name varchar2(15),
   member_age number,
   member_gender varchar2(5),
   memebr_email varchar2(30)
);

-- 테이블 구조변경 : 컬럼명 수정
alter table boardMember rename column memebr_email to member_email;

-- 전체레코드 검색
select * from boardMember;

-- 관리자 계정 입력
insert into boardMember(member_id, member_pw, member_name, member_age, member_gender, member_email)
  values('admin', 'admin', '관리자', 30, '남', 'admin@abc.com');

--커밋
commit;





