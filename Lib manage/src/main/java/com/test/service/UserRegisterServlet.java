package com.test.service;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class UserRegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L; // 1인데 long format으로 된 것
 
    // post형식으로 들어왔을 때
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
 
        // parameter 받아오기 -> index.jsp로부터 거기 보면 post형식으로 /userRegister라고 되어있음
        String userID = request.getParameter("userID");
        String userPassword1 = request.getParameter("userPassword1");
        String userPassword2 = request.getParameter("userPassword2");
        String userName = request.getParameter("userName");
        String userAge = request.getParameter("userAge");
        String userGender = request.getParameter("userGender");
        String userEmail = request.getParameter("userEmail");
 
        if (userID == null || userID.equals("") || userPassword1 == null || userPassword1.equals("")
                || userPassword2 == null || userPassword2.equals("") || userName == null || userName.equals("")
                || userAge == null || userAge.equals("") || userGender == null || userGender.equals("")
                || userEmail == null || userEmail.equals("")) {
            // 요청하는 것 -> index.jsp에서 일어날 일
            // reponse받아오는 것-> 실행후 해야할 일
            request.getSession().setAttribute("messageType", "오류 메시지");
            request.getSession().setAttribute("messageContent", "fill in the all blanks");
            response.sendRedirect("index.jsp");
            return;
        }
        if (!userPassword1.equals(userPassword2)) {
            request.getSession().setAttribute("messageType", "오류 메시지");
            request.getSession().setAttribute("messageContent", "two password are not equal");
            response.sendRedirect("index.jsp");
            return;
        }
        // UserDAO() //생성자 .register (그 class안에서register함수를 실행)
        int result = new UserDAO().register(userID, userPassword1, userName, userAge, userGender, userEmail);
        if (result == 1) {
            request.getSession().setAttribute("messageType", "성공 메시지");
            request.getSession().setAttribute("messageContent", "Successfully Signing Up");
            response.sendRedirect("index.jsp");
            return;
        } else {
            request.getSession().setAttribute("messageType", "오류 메시지");
            request.getSession().setAttribute("messageContent", "Failed to Sign Up");
            response.sendRedirect("index.jsp");
            return;
        }
    }
}


