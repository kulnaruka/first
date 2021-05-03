package com.page;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import com.mysql.cj.xdevapi.PreparableStatement;

public class LoginDao {
	String url = "jdbc:mysql://localhost:3306/sys";
	String username = "root";
	String password = "Kul_21513";
	String query = "select * from sys.USERS_DATABASE where uname = ? and pass = ?";
	
	public boolean check(String uname, String pass) throws SQLException, ClassNotFoundException {
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,username,password);
		
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1, uname);
		st.setString(2, pass);
		
		ResultSet rs = st.executeQuery();
		
		if (rs.next()) {
			return true;
		}
		else
			return false; 
	}
}
