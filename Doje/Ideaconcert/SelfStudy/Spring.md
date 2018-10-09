Spring 정리
================================================================

#### 생략된 개념 정리
  * 프레인워크란?

    * Enterprise Application에서 필요로 하는 기능을 제공하는 프레임워크

 

    * 장점

        -구조를 이해하거나 시용하는데 진입장벽이 높지않다.

        -경량화된 프레임워크이다.

        -다른 프레임워크들의 포용(여러 종류의 프레임워크를 혼용해 사용가능)

        -전체를 설계하는 용도로 사용될 수 있다
        
     * 따라서 기존 J2EE 기술을 보완한 스프링 프레임워크가 등장
        
        
         ![default](https://user-images.githubusercontent.com/42599885/46650060-3c4e3b80-cbd6-11e8-8c27-1552077be311.png)
        
        
   * 라이브러리란?


     * 애플리게이션 개발을 위해 사용되는 함수의 모음
  
     * 개별적으로 만들어 사용되기도 하나 개발 생산성을 높이기 위해 이미 만들어진 함수 라이브러리를 사용하기도 함


     * 장점

         * 코드의 재사용 및 부품화 실현

         * 소스를 제공하지 않아 중요기술 유출 방지

         * 개발 시간 단축

 

      * 정적 라이브러리

        * 코드가 실행 프로그램 컴파일 시에 실행 파일에(포함)되어 베포되는 방식

        * 실행파일 하나만으로 베포해도 충분함

        * Unix,Linux,DOS 등은 lib,I 등의 정적 라이브러리 사용

 

      * 동적 라이브러리 

        * 똑같은 코드들이 불필요하게 많은 메모리 자원을 중복해서 사용하는 등의 정적 라이브러리 단점을 보완하였다.

        * 애플리케이션에서 사용되는 공통 모듈을 메모리에 한 차례만 적재할 수 있다.

        * 사용이 끝나면 메모리에서 삭제됨
     
  * gradle이란?

      * 기본적인 '빌드 툴' 또는 '프로젝트 관리 도구' 

      * 스프링 오픈소스 프로젝트, 안드로이드 스튜디오에서 주로 사용됨

 

      * 장점

        * groovy언어를 사용하기 때문에 보다 유연하고 다양하게 구현이 가능하다.

        * 동적인 구현 가능

 

       * gradle 공식 사이트
          http://www.gradle.org
   * mybatis란?

      * 자바 개체와 sql을 연결하는  프레임워크

      * 자바의 관계형 데이터 프로그래밍을 좀 더 쉽게 할 수 있게 도와줌  
      
      * 장점

        * 유지보수가 쉬움

        * 리소스 관리

        * 작업의 분배

        * SQL문이 어플리케이션 소스코드로부터 완전히 분리된다.

        * 어떤 프로그래밍 언어로도 구현가능(JAVA,C#,RUBY 등등)
    
      * 구성

        1.환경설정파일(mybatis전반에 걸친 세팅)

 

        2.매핑 설정파일(사용할 sql문에 대한 정의)

 

        3.Session 빌드 및 사용(sql문 시행, sqlSession 오픈,id 호출해서 사용)
      
      * 스프링 예제 소스
      
        ~~~java
        public class LoginController extends MultiActionController{

 

             private LoginService loginService;



             public void setLoginService(LoginService loginService){

              this.loginService = loginService;

             }

             public ModelAndView loginPage(HttpServletRequest request, HttpServletResponse response){

              String id = request.getParameter("id");

              String pwd = request.getParameter("pwd");



              LoginVO param = new LoginVO();

              param.setId(id);

              param.setPwd(pwd);



              boolean result = loginService.getLoginAuthorizationCheck(param);

              ModelAndView mav = new ModelAndView();

              if(result){

               mav.setViewName("login/loginSuccess");

              }else{

               mav.setViewName("login/loginFail");

              }

              return mav;

             }

            }
          ~~~
