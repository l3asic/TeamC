CREATE TABLE user_C(

  ID		VARCHAR2(20 BYTE)   PRIMARY KEY,
	NAME	VARCHAR2(10 BYTE),
	SCORE	NUMBER,
	OX		VARCHAR2(20 BYTE),
	PASS	VARCHAR2(20 BYTE),
	CNT		NUMBER
);

insert into id values ('9999') --관리자 IdKey

desc user_c;

commit;