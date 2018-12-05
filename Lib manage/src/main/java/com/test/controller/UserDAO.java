package com.test.controller;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
 
//여기서 DTO에서 저장한 데이터를 가져와서 database에 적용!
public class UserDAO {
    //connection을 시작하지
    private Connection conn;
     
    //생성자 -> 실행하자마자 일어나야할일 -> Database에 연결되는 것
    public UserDAO() {
        //연결하자!
        try {
            //주의! DATABASE이름은 upper와 lower의 구분이 있음
            String dbURL = "jdbc:mysql://localhost:3306/register";
            String dbID = "root";
            String dbPassword = "자신의 비밀번호";
            //driver가져와줍니다
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(dbURL, dbID, dbPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    //이게 registerCheck 함수
    //registerCheckServlet에서 쓰임
    public int registerCheck(String userID) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String SQL = "SELECT * FROM user where userID = ?";
        try {
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, userID);
            //executeQuery라는 건 실행해서 나온 값이 있느냐 -> select때 사용
            rs = pstmt.executeQuery();
             
            if (rs.next()||userID.equals(""))
                return 0;
            else
                return 1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (pstmt != null)
                    pstmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }
 
    public int register(String userID, String userPassword, String userName, String userAge, String userGender,
            String userEmail) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String SQL = "INSERT INTO user VALUES (?,?,?,?,?,?)";
 
        try {
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, userID);
            pstmt.setString(2, userPassword);
            pstmt.setString(3, userName);
            pstmt.setInt(4, Integer.parseInt(userAge));
            pstmt.setString(5, userGender);
            pstmt.setString(6, userEmail);
             
            //insert때에는 executeUpdate를 사용해야
            //insert한 개수만큼 반환
            //1이면 한개 됬으니까 okay 0이면 한개도 안됬으니까 다시 insert해야 -> 이때는 ID가 같은 경우밖에 없음 (개발자가 잘 못 짰거나)
            return pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (pstmt != null)
                    pstmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }
}


