-- 테이블 생성

create table tblBook(
    title	 varchar2(30),
    name 	 varchar2(20),
    isbn 	 varchar2(20) primary key not null,
    comp 	 varchar2(20),
    cost	 number,
    qty 	 number,
    price	 number    
);
select * from tblBook;

delete from tblBook;
rollback;

update tblBook set title = '4', name = '4', comp = '4', cost = 4, qty = 4, price = 16 where isbn = '333-33-3333-333-1';



