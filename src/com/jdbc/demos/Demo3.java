package com.jdbc.demos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo3 {
	
public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/student","postgres","2411");
			System.out.println("Connection established");
			String sqlquery = "insert into employee_details values(?,?,?)";
			pstm = con.prepareStatement(sqlquery);
			pstm.setString(2, "Browny");
			pstm.setInt(1, 104);
			pstm.setInt(3, 13);
			pstm.execute();
			
			pstm.setString(2, "Chotu");
			pstm.setInt(1, 105);
			pstm.setInt(3, 1);
			pstm.execute();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
				pstm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
				
		
 
	}
 
}

	