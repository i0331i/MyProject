# MyProject

##  내용
이 파일은 MVC2 모델로 JSP에서 고객의 아이디와 비밀번호를 DTO에 보내 데이터베이스에 저장시킵니다.
후에 DAO가 데이터베이스와 연동하여 로그인 실행화면을 JSP화면으로 출력되게 합니다.

고객 정보(아이디,PASSWORD)를 입력받음 -> 서블릿에서 고객정보를 DTO에 전송 -> 전송된 정보를 DB에 저장함 -> DAO가 DB 연동 ->
JSP로 로그인 실행 화면 또는 실패 화면을 출력

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String id=request.getParameter("id");
	String pwd=request.getParameter("pwd");
	/*System.out.println(id + " " + pwd);*/
	
	LoginBiz biz = new LoginBiz();
	LoginEntity entity = biz.getLoginUser(id, pwd);
	
	//public LoginEntity getLoginUser(String id,String pwd){}
	
	if(entity != null) {
		/* 세션설정 */
		HttpSession session=request.getSession();
		session.setAttribute("logOK", entity);  //세션명 : logOK
		
		response.sendRedirect("/log/logtest/loginOK.jsp");
	}else {
		System.out.println("/log/logtest/loginFail.jsp");
		}
	}
}



##  주요 단어
1.
getparameter:object로 값을 가져옴.
2.
request:요청
3.
response:응답
4.
getSession:세션 생성
5.
setAttribute:속성값을 불러오는 메소드

##  더 알고 싶은 것
MVC1과 MVC2모델의 정확한 차이점을 잘 몰라 어떤 상황에 둘 중 어느 것을 대입시켜야하는지 모르겠다.
둘의 특징을 더 공부하여 상황에 따라 맞는 모델을 선택하고 싶다.
