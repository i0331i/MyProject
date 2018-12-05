JAVA keyword 정리
===============================


### GET vs POST 

* 공통점
  * HTTP 프로토콜을 이용해서 서버에 데이터를 전달할 때 사용하는 방식

* 차이점
  
  * GET
  
      * 데이터 전송시 파라미터에 노출됨(? 뒤에 주소가 붙여지는 형식)
    
      * URL에 이어붙기 때문에 길이제한이 있어 많은 양의 데이터 전송에 어려움
    
  * POST
    
      * Form태그를 이용하여 submit을 하는 형태
    
      * 파라미터에 값이 노출되지 않음
    
      * GET에 비해 많은 양의 데이터를 전송할 수 있다.

  
  * 따라서 GET은 데이터를 보여주는 용도로 쓰이고 POST는 직접 서버의 값이나 상태를 바꾸기 위해서 사용된다.
  
#### 어노테이션


* Controller란?

  * Model과 View간의 상호동작을 조정

  * 어노테이션을 이용해 컨트롤러를 개발하는 방법

  * MVC의 컨트롤러는 Contrller로 만들어진다

  * 특정 클래스를 구현하거나 상속할 필요가 없어짐
  
    ~~~java
    @Controller
    public class LoginController {
       ...
    }
    ~~~

* RequestMapping이란?
  * 요청에 대해 어떤 Controller, 어떤 메소드가 처리할지를 맵핑하기 위한 어노테이션(Annotation)
  
  * 클래스 단위나 메소드 단위로 설정할 수 있다.
  
  
    ~~~java
    @Controller
      @RequestMapping("/hello.do")
      public class HelloController {

      @RequestMapping   //type level에서 URL을 정의하고 Controller에 메소드가 하나만 있어도 요청 처리를 담당할 메소드 위에 @RequestMapping 표기를 해야 제대로 맵핑이 된다.
      public String hello(){
    ...		
      }
      ~~~

  }

  
* Configuration이란?

   * @Configuartion과 @Bean 어노테이션을 이용해서 스프링 컨테이너 새로운 빈 객체 제공
   
   * 스캔범위만 지정해주면 빈을 따로 등록할 필요가 없어짐.
   
   * @Configuration 어노테이션을 적용한다고 해서 스프링 컨테이너가 해당 클래스로부터 빈 정보를 구할 수 있는 것은 아님



      ~~~java
      @Configuration
      public class SpringConfig {

        @Bean
        public Greet greet(){
        return new Hello();
        }
      }
      ~~~
      
 * ResponseBody란?
    * 자바 객체를 HTTP 요청의 body 내용으로 매핑하는 역할을 하는 어노테이션
     
     ~~~java
     public @ResponseBody Users getUsersToXml() {
     }
     ~~~

 * JAVA Bean vs Spring Bean
 
    * JAVA Bean
      
      * 주로 데이터 표현을 목적으로 한다.
      
      * 프로그램의 재사용성을 증가시킨다.
      
      * jsp에서 객체를 가져다가 사용할 수 있다.
      
      * 자바빈의 규약을 따름
      
    * Spring Bean
      
      * 스프링 컨테이너에서 만들어지는 객체
      
      * 애플리케이션의 핵심을 이룬다.
      
      


 * web.xml이란?

    * Web Application의 Deployment Descriptor(환경 파일)로서 XML 형식의 파일

    * 모든 web application은 반드시 하나의 web.xml파일을 가져야 함.

    * 위치:WEB-INF 폴더 아래

    * web.xml 파일의 설정들은 Web Application 시작시 메모리에 로딩됨.(수정을 할 경우 web application을 재시작 해야함.)

    * 작성되는 내용
    
            1.ServletConext의 초기 파라미터

            2.Session의 유효시간 설정

            3.Servlet/JSP의 대한 정의

            4.Servlet/JSP 매핑

            5.Mime Type  매핑

            6.Welcome File list

            7.Error Page 처리   
    * 구조
      
      ![web](https://user-images.githubusercontent.com/42599885/46649315-9f8a9e80-cbd3-11e8-8f66-0e260662e6a4.jpg)
 
