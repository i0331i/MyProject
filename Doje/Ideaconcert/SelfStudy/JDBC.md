 JDBC keyword 정리
===============================================================================

* Java - Object Class

  * 모든 클래스의 부모인 클래스
  
  * 모든 클래스가 공통으로 포함하고 있어야 하는 기능 제공
  
  * extends java.lang.Object를 지정하지 않아도 자동으로 상속받음
  
  * 주요 메소드
     
    * boolean equals
    
    * String toString()
    * Class getClass()
    * int hashCode()
    * protected Object clone()

![233ba837529f47710a](https://user-images.githubusercontent.com/42599885/46710624-a7a21700-cc83-11e8-9a41-88aab35ac397.jpg)


* JDBC - prepareStatement

  * Connection 객체의 prepareStatement() 메소드를 사용해서 객체를 생성하는 인터페이스
  
  * prepareStatement()객체는 Statement에 비해 한번 사용한 SQL문이 저장되어 반복해서 사용할 경우 성능이 좋다.

  * 실행시간동안 인수 값을 위한 공간을 확보할 수 있다.
 
 
* JDBC - ResultSet

  * DB 명령에 대한 반환값을 저장하는 객체
  
  * select문을 처리함
  
  * 테이블 형태의 데이터 
