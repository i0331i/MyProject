모듈화 프로그래밍
=================================================
   * 모듈화 프로그래밍이란?

     * 프로그램을 모듈 단위(기능 단위)로 나누어서 하는 프로그래밍 또는 설계 기법

     * 장점
       * 개발과 유지 보수가 좋음
       * 코드의 재사용
       * 기능의 분리가 가능하고 인터페이스가 단순해짐
       * 오류의 파급 효과 최소화
     
     * 목표
       * 모듈 간 결합도의 최소화
       * 모듈 내 요소들 간의 응집도 최대화
       
     * 참조한 링크: <http://webclub.tistory.com/78>

   * ajax와 submit
     
     * ajax
          * 비동기식 처리 -> 대기시간 단축
          * 필요한 데이터만 전송, 응답
         
          * 코드예시
          ~~~java
              $.ajax({
              type : "POST",
              url  : "test.do",
              data : "data",
              success function(data){
                  //do action
              },
              error function(e){
                  alert(e);
              }
          })
          ~~~

     * submit
          * 동기식 처리
          * form을 사용하여 데이터 전송
          * 페이지가 리로드 된다. -> 매번 페이지를 읽어와 시간이 오래걸림
          * 로그인 페이지 이동 등에 사용된다.
          * 보고있는 페이지(데이터)를 전송하고 응답을 기다림
         
          * 코드예시
          ~~~java
             <form id="frm" name="frm" method="POST" action="test.do">
              <input type="text" id="data" name="data">
              <input type="submit" value="전송">
             </form>
           ~~~

