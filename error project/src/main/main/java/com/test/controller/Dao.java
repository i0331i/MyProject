package com.test.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
 
public class Dao {
    private Connection conn;
     
    //생성자 -> 실행하자마자 일어나야할일 -> Database에 연결되는 것
    public Dao() {
        //연결
        try {
            String dbURL = "jdbc:mysql://localhost:3306/register";
            String dbID = "root";
            String dbPassword = "자신의 비밀번호";
            //driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(dbURL, dbID, dbPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    public int registerCheck(String userID) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String SQL = "SELECT * FROM user where userID = ?";
        try {
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, userID);
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
             
            //insert한 개수만큼 반환
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


