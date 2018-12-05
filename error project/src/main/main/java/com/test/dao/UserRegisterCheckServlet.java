package com.test.dao;
import java.io.IOException;
 
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/UserRegisterCheckServlet")
public class UserRegisterCheckServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    // post형식으로 들어왔을 때
    // 실행
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
 
        //userID의 parameter
        String userID = request.getParameter("userID");
        // registerCheck이 int형을 반환 -> ""공백을 넣어줌으로써 성공적으로 문자열 형태로 text가 출력
        response.getWriter().write(new UserDAO().registerCheck(userID) + "");
    }
}


