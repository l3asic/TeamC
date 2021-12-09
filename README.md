insert into correctanswer_C values (4,2,1,4,4,2,4,2,3,4);
commit;

--------------------------------------------------

--------------------------------------------------
06.OMR_C_Ver_f.1.2
--------------------------------------------------
db테이블 : user_C 인서트가 없음 : oxox만들어서 그때그때 만들어오는 형식임
  correctanswer_c : ID VARCHAR2(10) 과목 추가 가능 -> dto dao 싹다수정해야됨

UserDAO : 메소드 수정
  미사용
    public ArrayList<UserDTO> newUl(String[] oxlist)d 
    eleteOmr()
  쿼리수정
    기응시자 검색 : select * from user_c where id like %?% ;
  
admin_Select.jsp 검색 결과
  userResult.jsp : 스타일 적용안됨,  검색창 다시 나오면 자연스러울것같음

단어수정

스타일은 수정안(못)했음
  style="width:80%";  margin-top:??;  
  
버튼정렬++
  버튼 링크, 기능, 위치 
 
--------------------------------------------------
  
--------------------------------------------------
