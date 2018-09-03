My Project
=====================
내용 
---------------------------
이 LoginDao 파일은 사용자가 요청한 데이터 처리를 한 후에, 결과를 리턴해주는 역할을 합니다.
LoginEntity를 받아서 DB에 접근해 해당 정보를 취득하고 아이디와 비번이 맞는지 체크하고 그 결과를 다시 LoginBiz에 돌려줍니다.

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


더 알고 싶은 것
------------------------------------------------------
