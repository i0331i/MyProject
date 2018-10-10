My Project(LoginDAO)
=====================
  * 내용 
    * 메소드명 : getLoginUser
    * 로직 : 비즈니스 로직(Business Logic)
    * 리턴값 : entity

~~~java
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ResultTreeType;

import static common.JdbcTemplate.getConnection;
import static common.JdbcTemplate.close;
import entity.LoginEntity;

//DAO(Data Access Object):데이터베이스와 연동해서 CRUD처리
public class LoginDao {

	public LoginEntity getLoginUser(String id, String pwd) {
		 Connection conn=getConnection();
		 PreparedStatement pstmt = null;
		 ResultSet rs =null;
		 LoginEntity entity = null;
		 
		 try {
			 String sql="select * from users where id=? and pwd=?";
			 pstmt=conn.prepareStatement(sql);
			 pstmt.setString(1,id);
			 pstmt.setString(2,pwd);
			 rs = pstmt.executeQuery();
			 
			 if(rs.next()) {
				 entity = new LoginEntity();
				 entity.setId(rs.getString("ID"));
				 entity.setId(rs.getString("PWD"));
				 entity.setId(rs.getString("NAME"));
				 entity.setId(rs.getString("POINT"));
			 }
			 
		 }catch(SQLException e){
			 e.printStackTrace();
			 
		 }finally {
			 close(rs);
			 close(pstmt);
			 close(conn);
		 }
		 return entity;
		
	}
}
/*
 <다른처리방법>
 [방법1]객체생성해서 접근
  import common.JdbcTemplate;
 
 JdbcTemplate ob = new JdbcTemplate();
 Connection conn= ob.getConnection();
 
 conn.close(conn);

----------------------------------------------------------- 
 [방법2]
 import common.JdbcTemplate;
 
 Connection conn=JdbcTemplate.getConnection();
JdbcTemplate.close(conn); 
 */
 ~~~
 
 
 주요 단어
---------------------------------------------------
  1.printStackTrace:예외처리 메소드
  
  2.preparedStatement:Connection 객체의 prepareStatement() 메소드를 사용해서 객체를 생성하는 인터페이스 
  
  3.resultset:DB 명령에 대한 반환값을 저장하는 객체 

더 알고 싶은 것
----------------------------------------------------

